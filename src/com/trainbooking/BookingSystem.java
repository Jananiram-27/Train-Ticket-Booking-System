package com.trainbooking;

import java.util.*;
import java.io.*;

public class BookingSystem {
    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public BookingSystem() {

        trainList.add(new Train(101, "Express A", "Chennai", "Bangalore", 50));
        trainList.add(new Train(102, "Express B", "Chennai", "Hyderabad", 60));
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n---- Train Ticket Booking System ----");
            System.out.println("1. Display Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> displayTrains();
                case 2 -> bookTicket();
                case 3 -> cancelTicket();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void displayTrains() {
        System.out.println("\nAvailable Trains:");
        for (Train t : trainList) {
            t.displayTrainInfo();
        }
    }

    private void bookTicket() {
        displayTrains();
        System.out.print("Enter Train Number: ");
        int trainNum = sc.nextInt();
        sc.nextLine();

        Train selectedTrain = null;
        for (Train t : trainList) {
            if (t.getTrainNumber() == trainNum) {
                selectedTrain = t;
                break;
            }
        }

        if (selectedTrain == null) {
            System.out.println("Invalid Train Number!");
            return;
        }

        System.out.print("Number of passengers: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (selectedTrain.getAvailableSeats() == 0) {
                System.out.println("No more seats available.");
                break;
            }
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter gender: ");
            String gender = sc.nextLine();

            if (selectedTrain.bookSeat()) {
                passengers.add(new Passenger(name, age, gender, selectedTrain.getNextSeatNumber()));
            }
        }

        Ticket ticket = new Ticket(selectedTrain, passengers);
        ticketList.add(ticket);
        System.out.println("Ticket booked successfully!");
        ticket.displayTicket();
    }

    private void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = sc.nextInt();
        sc.nextLine();

        Ticket ticketToCancel = null;
        for (Ticket t : ticketList) {
            if (t.getTicketID() == id) {
                ticketToCancel = t;
                break;
            }
        }

        if (ticketToCancel != null) {
            for (Passenger p : ticketToCancel.getPassengerList()) {
                ticketToCancel.getTrain().cancelSeat();
            }
            ticketList.remove(ticketToCancel);
            System.out.println("Ticket canceled successfully.");
        } else {
            System.out.println("Ticket ID not found.");
        }
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        system.showMenu();
    }
}
