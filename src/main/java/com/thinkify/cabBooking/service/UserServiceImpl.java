package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.exception.DriverNotFoundException;
import com.thinkify.cabBooking.exception.NoStrongPasswordException;
import com.thinkify.cabBooking.module.*;
import com.thinkify.cabBooking.repository.CustomerDAO;
import com.thinkify.cabBooking.repository.DriverDAO;
import com.thinkify.cabBooking.util.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private DriverDAO driverDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoggedInUser loggedInUser;

    @Override
    public boolean addUser(CustomerDTO customerDTO) {
        customerDAO.save(mapToCustomer(customerDTO));
        return true;
    }

    @Override
    public List<Driver> searchRide(LocationDto locationDto) {

        Location customerLocation = locationDto.getSourceLocation();



        List<Driver> driverList = new ArrayList<>();

        for(Driver driver : driverDAO.findAll()){
           // System.out.println(driver);
            Float lattitude = Math.abs(driver.getCar().getCurrentLocation().getLattitude()- customerLocation.getLattitude());
            Float longitude = Math.abs(driver.getCar().getCurrentLocation().getLongitude() - customerLocation.getLongitude());

            if(lattitude<6 && longitude <6){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    @Override
    public synchronized Booking bookRide(String driverID, LocationDto locationDto) {

        Optional<Driver> driverOptional = driverDAO.findById(driverID);

        if (!driverOptional.isPresent()){
            throw new DriverNotFoundException("The provided Driver Not Available");
        }

        Driver driver = driverOptional.get();
        Customer customer = (Customer) loggedInUser.getCurrentUser();
        Booking booking = new Booking();
        booking.setDriver(driver);
        booking.setCustomer(customer);
        booking.setDestination(locationDto.getDestination());
        booking.setSourceLocation(locationDto.getSourceLocation());
        booking.setTimeStamp(LocalDateTime.now());
        booking.setBillAmount(driver.getCar().getFarePerKM()*3);

        driver.setStatus(Status.ONGOING);
        driver.getBookingHistory().add(booking);

        customer.getBookings().add(booking);

        driverDAO.save(driver);
       Customer customer1 = customerDAO.save(customer);

        return customer1.getBookings().get(customer1.getBookings().size()-1 );
    }

    private Customer mapToCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setAge(customerDTO.getAge());
        customer.setName(customerDTO.getName());
        customer.setRole("ROLE_CUSTOMER");
        customer.setMobileNumber(customerDTO.getMobileNumber());

        if(customerDTO.getGender().toUpperCase().equals("M")){
            customer.setGender(Gender.MALE);
        }else  if(customerDTO.getGender().toUpperCase().equals("F")){
            customer.setGender(Gender.FEMALE);
        }else {
            customer.setGender(Gender.OTHERS);
        }

        if(isValidPassword(customerDTO.getPassword())){
            customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        }else{
            throw new NoStrongPasswordException("Password dosen't meet the password criteria");
        }

        return customer;
    }


    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(password);

        return m.matches();
    }
}
