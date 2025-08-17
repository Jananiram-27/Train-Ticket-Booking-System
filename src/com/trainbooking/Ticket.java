package com.trainbooking;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {
    private static int counter = 1000;
    private int ticketID;
    private Train train;
    private List<Passenger> passengerList;

    public Ticket(Train train, List<Passenger> passengerList) {
        this.ticketID = counter++;
        this.train = train;
        this.passengerList = passengerList;
    }

    public void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Ticket ID: " + ticketID);
        train.displayTrainInfo();
        System.out.println("Passengers:");
        for (Passenger p : passengerList) {
            p.displayPassengerInfo();
        }
    }

    public int getTicketID() {
        return ticketID;
    }


    public Train getTrain() {
        return train;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }
}
