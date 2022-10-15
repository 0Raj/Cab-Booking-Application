package com.thinkify.cabBooking.service;

import com.thinkify.cabBooking.util.LoggedInUser;
import com.thinkify.cabBooking.exception.NoStrongPasswordException;
import com.thinkify.cabBooking.module.*;
import com.thinkify.cabBooking.repository.DriverDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriverDAO driverDAO;

    @Autowired
    private LoggedInUser loggedInUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addDriver(DriverDTO driverDTO) {

        Driver driver = mapDriver(driverDTO);
        driverDAO.save(driver);

    }

    @Override
    public void addCar(CarDTO carDTO) {

        Driver driver = (Driver)loggedInUser.getCurrentUser();
        driver.setCar(mapToCar(carDTO));

        driverDAO.save(driver);

    }


    private Driver mapDriver(DriverDTO driverDTO){

        Driver driver = new Driver();
        driver.setName(driverDTO.getName());

        if(driverDTO.getGender().toUpperCase().equals("M")){
            driver.setGender(Gender.MALE);
        }else  if(driverDTO.getGender().toUpperCase().equals("F")){
            driver.setGender(Gender.FEMALE);
        }else {
            driver.setGender(Gender.OTHERS);
        }

        driver.setDrivingLicense(driverDTO.getDrivingLicense());
        driver.setRole("ROLE_DRIVER");
        driver.setMobileNumber(driverDTO.getMobileNumber());
        driver.setAge(driverDTO.getAge());

        if(isValidPassword(driverDTO.getPassword())){
            driver.setPassword(passwordEncoder.encode(driverDTO.getPassword()));
        }else{
            throw new NoStrongPasswordException("Password dosen't meet the password criteria");
        }

        driver.setStatus(Status.AVAILABLE);

        return driver;
    }

    private Car mapToCar(CarDTO carDTO){
        Driver driver = (Driver) loggedInUser.getCurrentUser();

        Car car = new Car();
        car.setDriver(driver);
        car.setCarNumberPlate(carDTO.getCarNumberPlate());
        car.setCurrentLocation(carDTO.getCurrentLocation());
        car.setSeatCapacity(carDTO.getSeatCapacity());
        car.setFarePerKM(carDTO.getFarePerKM());

        return car;
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
