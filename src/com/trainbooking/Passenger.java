package com.trainbooking;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String passengerName;
    private int age;
    private String gender;
    private int seatNumber;

    public Passenger(String passengerName, int age, String gender, int seatNumber) {
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.seatNumber = seatNumber;
    }

    public void displayPassengerInfo() {
        System.out.println("Seat " + seatNumber + ": " + passengerName + ", Age: " + age + ", Gender: " + gender);
    }
}
