package application;

import model.entities.Reservation;
import model.exception.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();

            System.out.print("Check-in date (dd/mm/yyyy): ");
            String checkInInput = sc.next();
            LocalDate checkIn = LocalDate.parse(checkInInput, fmt);

            System.out.print("Check-out date (dd/mm/yyyy): ");
            String checkOutInput = sc.next();
            LocalDate checkOut = LocalDate.parse(checkOutInput, fmt);


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkInInput = sc.next();
            checkIn = LocalDate.parse(checkInInput, fmt);

            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOutInput = sc.next();
            checkOut = LocalDate.parse(checkOutInput, fmt);

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Updated Reservation: " + reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error.");
        }
        
        sc.close();
    }
}
