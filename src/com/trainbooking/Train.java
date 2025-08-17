package com.trainbooking;

import java.io.Serializable;

public class Train implements Serializable {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    public int getNextSeatNumber() {
        return totalSeats - availableSeats + 1;
    }

    public void displayTrainInfo() {
        System.out.println(trainNumber + " - " + trainName + " | " + source + " -> " + destination
                + " | Seats Available: " + availableSeats);
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getTrainNumber() {
        return trainNumber;
    }
}
