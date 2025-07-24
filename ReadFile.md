Car Selection System

This Project is Done by
1.Dhanya
2.Duveen Kumar Reddy
3.Dakshata
4.HemaVarshini

The Car Selection System is a Java-based console application that allows users to search for cars based on various criteria, register accounts, and send car details via email. This system enables users to log in, register, and browse through cars filtered by brand, performance, safety, price range, and type. After selecting a car, users can choose to receive detailed car information at a specified email address.

Features
User Registration and Login: Allows users to create an account and log in to access the car search features.
Car Search Options: Users can search for cars based on brand, performance, safety, type, and price range.
Top 10 Lists: Displays the top 10 cars based on luxury or latest models.
Car Selection: Users can select a car and optionally receive detailed information via email.
Email Notification: Sends the selected car's details to a specified email address using JavaMailSender and Spring Boot.
Prerequisites
Java 8 or higher
Maven (for managing dependencies)
Spring Boot (for email sending functionality)
JavaMailSender (for SMTP integration)
Project Structure
CarSear.java: Main program that handles user interaction, login, and search functionalities.
CarSearchApplication.java: Configures the Spring Boot application and initializes the email sending service.
EmailSenderService.java: Service for sending emails with selected car details.
users.csv: CSV file containing user data in the format:
graphql

Username, Password, Name, Email, Phone, Car Brand, Car Model, Car Type, Car Year
CarData.csv: CSV file containing car data, including brand, model, type, performance, safety, and price details.
Getting Started
Installation

cd CarSelectionSystem
Set up dependencies: Make sure your pom.xml file includes dependencies for Spring Boot and JavaMailSender.

Configure SMTP: Update the application.properties file in your project’s resources folder with your SMTP email settings:

spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

Usage
Login/Register: When you start the application, you can either log in with an existing account or register a new one.
Search for Cars: Use the car search options to filter and browse through the available cars in CarData.csv.
Select and Email Car Details:
After selecting a car, choose the option to receive the car's details via email.
The application will send the car details to the specified email address using the SMTP configuration.
Code Structure


src
├── main
│   ├── java
│   │   └── com.CarSeach.CarSearch
│   │       ├── CarSear.java                  # Main class for handling user interactions
│   │       ├── CarSearchApplication.java      # Spring Boot application configuration
│   │       └── EmailSenderService.java        # Service class for email functionality
│   └── resources
│       ├── application.properties             # Properties for email configuration
│       └── data
│           ├── users.csv                      # User data
│           └── CarData.csv                    # Car data
Sample Usage
Welcome to the Car Selection System!
1. Log in
2. Register
3. Exit
Choose an option: 1

Enter your username: johndoe
Enter your password: ********

--- Car Search Options ---
1. Search by Brand
2. Search by Performance
...
Choose an option: 1

Enter car brand: Toyota

--- Displaying Results ---
Brand: Toyota
Model: Camry
Type: Sedan
...

Would you like to receive this car's details by email? (yes/no): yes
Enter your email to receive car details: user@example.com
Car details have been sent to user@example.com

Potential Improvements
Add GUI for better user experience.
Implement more advanced filtering options.
Add more detailed car specifications.
Integrate SMS notification functionality.


This README provides a comprehensive overview of the Car Selection System, including installation instructions, configuration, and usage. Feel free to update it further with more project-specific details if needed!