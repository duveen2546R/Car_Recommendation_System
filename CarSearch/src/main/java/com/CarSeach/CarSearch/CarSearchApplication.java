package com.CarSeach.CarSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class CarSearchApplication {

    @Autowired
    private EmailSenderService emailSenderService;

    public static void main(String[] args) {
        SpringApplication.run(CarSearchApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n\nPlease Enter your Details Once more to Send An Email");
        
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        String carDetails = getCarDetailsFromCSV(username);
        
        if (carDetails != null) {
            System.out.print("Enter the email address to receive the car details: ");
            String recipientEmail = scanner.nextLine();
            
            String subject = " Car Selection Details of "+username;
            
            emailSenderService.sendEmail(recipientEmail, subject, carDetails);
            System.out.println("Car details have been sent to " + recipientEmail);
        } else {
            System.out.println("No car details found for username: " + username);
        }

        scanner.close();
    }

    public String getCarDetailsFromCSV(String username) {
        String filePath = "users.csv";
        String carDetails = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");

                if (userData.length >= 9 && userData[0].equals(username)) {
                    String carBrand = userData[5];
                    String carModel = userData[6];
                    String carType = userData[7];
                    String carYear = userData[8];

                    carDetails = String.format("Your Selected Car Details:\nBrand: %s\nModel: %s\nType: %s\nYear: %s", 
                                                carBrand, carModel, carType, carYear);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
        }

        return carDetails;
    }
}
