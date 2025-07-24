package com.CarSeach.CarSearch;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String toCSV() {
        return username + "," + password;
    }

    public static User fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new User(parts[0], parts[1]);
    }
}

class Car{
    private String brand;
    private String model;
    private String type;
    private int year;

    public Car(String brand,String model,String type,int year){
        this.brand=brand;
        this.model=model;
        this.type=type;
        this.year=year;
    }

    String getBrand(){
        return brand;
    }
    String getModel(){
        return model;
    }
    String getType(){
        return type;
    }
    int getYear(){
        return year;
    }
}

interface PerformanceIntf{
    public int getEnginePower();
    public int getTopSpeed();
    public double getAcceleration();
    public void displayPerformance();
}

interface SafetyIntf{
    public int getAirbags();
    public boolean hasABS();
    public boolean hasCruiseControl();
    public boolean hasCollisionWarning();
    public boolean hasParkingSensor();
    public boolean hasBlindSpotDetection();
    public void displaySafety();
}

interface LuxuryIntf{
    public boolean hasLeatherSeats();
    public boolean hasSoundSystem();
    public boolean hasRecliner();
    public int supensionRating();
    public boolean hasVoiceControl();
    public boolean hasSunroof();
    public boolean hasStarlightRoof();
    public void displayLuxury();
}

interface PriceIntf{
    public double getMinPrice();
    public double getMaxPrice();
    public void displayPrice();
}

class Performance extends Car implements PerformanceIntf{
    private int enginePower;
    private int topSpeed;
    private double Acceleration;
    private int performanceScore; 

    public Performance(String brand,String model,String type,int year,int enginePower,int topSpeed,double Acceleration){
        super(brand, model, type, year);
        this.enginePower=enginePower;
        this.topSpeed=topSpeed;
        this.Acceleration=Acceleration;
    }

    public int getEnginePower(){
        return enginePower;
    }

    public int getTopSpeed(){
        return topSpeed;
    }

    public double getAcceleration(){
        return Acceleration;
    }

    public void displayPerformance(){
        System.out.println("Car Details based on Performance \n Make :"+getBrand()+"\n Model :"+getModel()+"\n Type : "+getType()+"\n Year : "+getYear()+"\n EnginePower :"+getEnginePower()+"\n Accerlation(0-100) :"+getAcceleration());
    }

    public int getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(int performanceScore) {
        this.performanceScore = performanceScore;
    }

}

class Safety extends Car implements SafetyIntf{
    private int airbags;
    private boolean CollisionWarning;
    private boolean ParkingSensor;
    private boolean ABS;
    private boolean cruiseControl;
    private boolean BlindSpotDetector;
    private int safetyScore;
    
    public Safety(String brand,String model,String type,int year,int airbags,boolean CollisionWarning,boolean ParkingSensor,boolean ABS,boolean cruiseControl,boolean BlindSpotDetector){
        super(brand, model, type, year);
        this.airbags=airbags;
        this.CollisionWarning=CollisionWarning;
        this.ParkingSensor=ParkingSensor;
        this.ABS=ABS;
        this.cruiseControl=cruiseControl;
        this.BlindSpotDetector=BlindSpotDetector;
    }

    public int getAirbags(){
        return airbags;
    }

    public boolean hasCollisionWarning(){
        return CollisionWarning;
    }

    public boolean hasParkingSensor(){
        return ParkingSensor;
    }

    public boolean hasABS(){
        return ABS;
    }

    public boolean hasCruiseControl(){
        return cruiseControl;
    }

    public boolean hasBlindSpotDetection(){
        return BlindSpotDetector;
    }

    public void displaySafety(){
        System.out.println("Car Details based on Safety \n Make :"+getBrand()+"\n Model :"+getModel()+"\n Type : "+getType()+"\n Year : "+getYear()+"\n Airbags :"+getAirbags()+"\n Has Collison Warning :"+hasCollisionWarning()+"\n Has ParkingSensor :"+hasParkingSensor()+"\n Has Anti Braking System :"+hasABS()+"\n Has Cruise Control"+hasCruiseControl()+"Has BlindSpot Detection :"+hasBlindSpotDetection());
    }

    public int getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(int safetyScore) {
        this.safetyScore = safetyScore;
    }
}

class Luxury extends Car implements LuxuryIntf{
    private boolean LeatherSeats;
    private boolean SoundSystem;
    private boolean Recliner;
    private int SuspensionRating;
    private boolean VoiceConrtrol;
    private boolean Sunroof;
    private boolean StarlightRoof;

    public Luxury(String brand,String model,String type,int year,boolean LeatherSeats,boolean SoundSystem,boolean Recliner,int SuspensionRating,boolean VoiceConrtrol,boolean Sunroof,boolean StarlightRoof){
        super(brand, model, type, year);
        this.LeatherSeats=LeatherSeats;
        this.SoundSystem=SoundSystem;
        this.Recliner=Recliner;
        this.SuspensionRating=SuspensionRating;
        this.VoiceConrtrol=VoiceConrtrol;
        this.Sunroof=Sunroof;
        this.StarlightRoof=StarlightRoof;
    }

    public boolean hasLeatherSeats(){
        return LeatherSeats;
    }

    public boolean hasSoundSystem() {
        return SoundSystem;
    }

    public boolean hasRecliner() {
        return Recliner;
    }

    public int supensionRating() {
        return SuspensionRating;
    }

    public boolean hasVoiceControl() {
        return VoiceConrtrol;
    }

    public boolean hasSunroof() {
        return Sunroof;
    }

    public boolean hasStarlightRoof() {
        return StarlightRoof;
    }

    public void displayLuxury() {
        System.out.println("Car Details based on Luxury \n Make :"+getBrand()+"\n Model :"+getModel()+"\n Type : "+getType()+"\n Year : "+getYear()+"\n Has Leather Seats :"+hasLeatherSeats()+"\n Has SoundSystem :"+hasSoundSystem()+"\n Has Recliners :"+hasRecliner()+"\n Suspension Rating :"+supensionRating()+"\n Has Voice Control :"+hasVoiceControl()+"\n Has Sunroof :"+hasSunroof()+"Has StarlightRoof :"+hasStarlightRoof());
    }

}

class Price extends Car implements PriceIntf{
    private double minPrice;
    private double maxPrice;

    public Price(String brand,String model,String type,int year,double minPrice,double maxPrice){
        super(brand, model, type, year);
        this.minPrice=minPrice;
        this.maxPrice=maxPrice;
    }

    public double getMinPrice(){
        return minPrice;
    }
    public double getMaxPrice(){
        return maxPrice;
    }

    public void displayPrice(){
        System.out.println("Car Details based on Performance \n Make :"+getBrand()+"\n Model :"+getModel()+"\n Type : "+getType()+"\n Year : "+getYear()+"\n Base Price :"+getMinPrice()+"\n TopEnd Price :"+getMaxPrice());
    }

}

@SpringBootApplication
public class CarSear {

    private Map<String, User> userDatabase = new HashMap<>();
    private static final String USER_CSV_FILE = "users.csv";

    public CarSear() {
        loadUsersFromCSV(USER_CSV_FILE); 
    }

    
    public boolean registerUser(String username, String password) {
        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return false;
        }
        User newUser = new User(username, password);
        userDatabase.put(username, newUser);
        saveUserToCSV(newUser, USER_CSV_FILE);
        System.out.println("Registration successful! You can now log in.");
        return true;
    }

    public boolean loginUser(String username, String password) {
        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            return true;
        }
        System.out.println("Invalid username or password. Please try again.");
        return false;
    }

    private void saveUserToCSV(User user, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(user.toCSV());
            bw.newLine();
            System.out.println("User details saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsersFromCSV(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("User CSV file not found. Starting with an empty user database.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                User user = User.fromCSV(line);
                userDatabase.put(user.getUsername(), user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void saveCarSelectionToUserCSV(String username, Car selectedCar) {
        List<String[]> rows = new ArrayList<>();
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV_FILE))) {
            String line = br.readLine(); 
            String[] header = line.split(",");
            rows.add(header); 

            if (header.length < 7) {
                rows.set(0, new String[]{"Username", "Password", "Name", "Email", "Phone", "Car Brand", "Car Model", "Car Type", "Car Year"});
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(username)) { 
                    userFound = true;
                    data = Arrays.copyOf(data, 9); 
                    data[5] = selectedCar.getBrand();
                    data[6] = selectedCar.getModel();
                    data[7] = selectedCar.getType();
                    data[8] = String.valueOf(selectedCar.getYear());
                }
                rows.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userFound) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_CSV_FILE))) {
                for (String[] row : rows) {
                    bw.write(String.join(",", row));
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User not found in users.csv.");
        }
    }

    public String getUserCarDetailsFromCSV(String filePath, String username) {
        StringBuilder carDetails = new StringBuilder();
    
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
    
                if (data.length >= 9 && data[0].equalsIgnoreCase(username)) {
                    String brand = data[5];
                    String model = data[6];
                    String type = data[7];
                    String year = data[8];
    
                    carDetails.append("Car Details:\n")
                              .append("Brand: ").append(brand).append("\n")
                              .append("Model: ").append(model).append("\n")
                              .append("Type: ").append(type).append("\n")
                              .append("Year: ").append(year).append("\n");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user details from CSV: " + e.getMessage());
        }
    
        return carDetails.toString();
    }

    public void selectCar(String username, Scanner scanner) { 
        System.out.print("Enter the car brand: ");
        String brand = scanner.nextLine();
        
        System.out.print("Enter the car model: ");
        String model = scanner.nextLine();
        
        System.out.print("Enter the car type: ");
        String type = scanner.nextLine();
        
        System.out.print("Enter the car year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 
        
        Car selectedCar = new Car(brand, model, type, year);
        
        List<Car> carData = loadCarsFromCSV("CarData.csv");
        
        boolean carExists = carData.stream().anyMatch(car ->
            car.getBrand().equalsIgnoreCase(brand) &&
            car.getModel().equalsIgnoreCase(model) &&
            car.getType().equalsIgnoreCase(type) &&
            car.getYear() == year
        );
        
        if (carExists) {
            saveCarSelectionToUserCSV(username, selectedCar);
            System.out.println("Car selection saved successfully!");
        } else {
            System.out.println("We Do not have the Details of Car You Requested !");
        }
    }
    
    public void viewSelectedCar(String username) {
        boolean userFound = false;
    
        try (BufferedReader br = new BufferedReader(new FileReader(USER_CSV_FILE))) {
            String line = br.readLine(); 
    
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
    
                if (data[0].equals(username)) { 
                    userFound = true;
    
                    if (data.length >= 9 && data[5] != null && !data[5].isEmpty()) {
                        System.out.println("Car details for user " + username + ":");
                        System.out.println("Brand: " + data[5]);
                        System.out.println("Model: " + data[6]);
                        System.out.println("Type: " + data[7]);
                        System.out.println("Year: " + data[8]);
                    } else {
                        System.out.println("No car selected for user " + username + ".");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (!userFound) {
            System.out.println("User " + username + " not found in the users.csv file.");
        }
    }
    
    public List<Car> loadCarsFromCSV(String fileName) {
        List<Car> carList = new ArrayList<>();
        String line;
    
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
    
                String brand = data[0];
                String model = data[1];
                String type = data[2];
                int year = Integer.parseInt(data[3]);
    
                int enginePower = Integer.parseInt(data[4]);
                int topSpeed = Integer.parseInt(data[5]);
                double acceleration = Double.parseDouble(data[6]);
    
                int airbags = Integer.parseInt(data[7]);
                boolean collisionWarning = Boolean.parseBoolean(data[8]);
                boolean parkingSensor = Boolean.parseBoolean(data[9]);
                boolean abs = Boolean.parseBoolean(data[10]);
                boolean cruiseControl = Boolean.parseBoolean(data[11]);
                boolean blindSpotDetector = Boolean.parseBoolean(data[12]);
    
                boolean leatherSeats = Boolean.parseBoolean(data[13]);
                boolean soundSystem = Boolean.parseBoolean(data[14]);
                boolean recliner = Boolean.parseBoolean(data[15]);
                int suspensionRating = Integer.parseInt(data[16]);
                boolean voiceControl = Boolean.parseBoolean(data[17]);
                boolean sunroof = Boolean.parseBoolean(data[18]);
                boolean starlightRoof = Boolean.parseBoolean(data[19]);
    
                double minPrice = Double.parseDouble(data[20]);
                double maxPrice = Double.parseDouble(data[21]);
    
                Performance performanceCar = new Performance(brand, model, type, year, enginePower, topSpeed, acceleration);
                Safety safetyCar = new Safety(brand, model, type, year, airbags, collisionWarning, parkingSensor, abs, cruiseControl, blindSpotDetector);
                Luxury luxuryCar = new Luxury(brand, model, type, year, leatherSeats, soundSystem, recliner, suspensionRating, voiceControl, sunroof, starlightRoof);
                Price priceCar = new Price(brand, model, type, year, minPrice, maxPrice);
    
                carList.add(performanceCar);
                carList.add(safetyCar);
                carList.add(luxuryCar);
                carList.add(priceCar);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    
        return carList;
    }
    
    public void searchByBrand(String brand, List<Car> cars) {
        List<Car> brandCars = new ArrayList<>();
        
        System.out.println("Searching for cars with brand: " + brand);
    
        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                brandCars.add(car);
            }
        }
    
        if (brandCars.isEmpty()) {
            System.out.println("No cars found for the brand: " + brand);
        } else {
            for (Car car : brandCars) {
                System.out.println("\nBrand: " + car.getBrand() +
                        "\nModel: " + car.getModel() +
                        "\nType: " + car.getType());
    
            }
        }
    }

    public void searchByPerformance(List<Car> cars) {
        List<Performance> performanceCars = new ArrayList<>();

        for (Car car : cars) {
            if (car instanceof Performance) {
                performanceCars.add((Performance) car);
            }
        }

        for (Performance car : performanceCars) {
            int score = calculatePerformanceScore(car);
            car.setPerformanceScore(score); 
        }

        Collections.sort(performanceCars, Comparator.comparingInt(Performance::getPerformanceScore).reversed());

        System.out.println("Top 10 Cars based on Performance:");
        for (int i = 0; i < Math.min(10, performanceCars.size()); i++) {
            Performance car = performanceCars.get(i);
            System.out.println("\nRank " + (i + 1) + ":");
            car.displayPerformance();
            System.out.println("Performance Score: " + car.getPerformanceScore());
        }
    }

    private int calculatePerformanceScore(Performance car) {
        int enginePowerScore = Math.min(40, (car.getEnginePower() / 100) * 40); 
        int topSpeedScore = Math.min(30, (car.getTopSpeed() / 300) * 30); 
        int accelerationScore = (int) Math.min(30, (10 / car.getAcceleration()) * 30); 

        return enginePowerScore + topSpeedScore + accelerationScore;
    }

    public void searchBySafety(List<Car> cars) {
        List<Safety> safetyCars = new ArrayList<>();
    
        for (Car car : cars) {
            if (car instanceof Safety) {
                safetyCars.add((Safety) car);
            }
        }
    
        for (Safety car : safetyCars) {
            int score = calculateSafetyScore(car);
            car.setSafetyScore(score);  
        }
    
        Collections.sort(safetyCars, Comparator.comparingInt(Safety::getSafetyScore).reversed());
    
        System.out.println("Top 10 Cars based on Safety:");
        for (int i = 0; i < Math.min(10, safetyCars.size()); i++) {
            Safety car = safetyCars.get(i);
            System.out.println("\nRank " + (i + 1) + ":");
            car.displaySafety();
            System.out.println("Safety Score: " + car.getSafetyScore());
        }
    }
    
    private int calculateSafetyScore(Safety car) {
        int airbagsScore = Math.min(70, car.getAirbags() * 5);  
        int absScore = car.hasABS() ? 10 : 0;                   
        int collisionWarningScore = car.hasCollisionWarning() ? 5 : 0;  
        int parkingSensorScore = car.hasParkingSensor() ? 5 : 0;        
        int cruiseControlScore = car.hasCruiseControl() ? 5 : 0;        
        int blindSpotScore = car.hasBlindSpotDetection() ? 5 : 0;       
    
        return airbagsScore + absScore + collisionWarningScore + parkingSensorScore + cruiseControlScore + blindSpotScore;
    }
    

    public void displayTop10LuxuryCars(List<Car> cars) {
        System.out.println("\nTop 10 Luxury Cars:");
    
        List<Luxury> luxuryCars = cars.stream()
                .filter(car -> car instanceof Luxury) 
                .map(car -> (Luxury) car)
                .sorted(Comparator.comparingInt(Luxury::supensionRating).reversed() 
                        .thenComparing(Luxury::hasLeatherSeats).reversed() 
                        .thenComparing(Luxury::hasSunroof).reversed()) 
                .limit(10) 
                .toList();
    
        int rank = 1;
        for (Luxury car : luxuryCars) {
            System.out.println("\nRank " + rank + ":");
            car.displayLuxury();
            rank++;
        }
    }
    
    public void displayTop10LatestModels(List<Car> cars) {
        System.out.println("\nTop 10 Latest Car Models:");
    
        List<Car> latestCars = cars.stream()
                .distinct() 
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .limit(10) 
                .toList();
    
        int rank = 1;
        for (Car car : latestCars) {
            System.out.println("\nRank " + rank + ":");
            System.out.println("Make: " + car.getBrand() +
                    "\nModel: " + car.getModel() +
                    "\nType: " + car.getType() +
                    "\nYear: " + car.getYear());
            rank++;
        }
    }

    public void searchByMaxPrice(List<Car> cars, double maxPrice) {
        List<Price> filteredCars = cars.stream()
                .filter(car -> car instanceof Price)  
                .map(car -> (Price) car)  
                .filter(priceCar -> priceCar.getMaxPrice() <= maxPrice)
                .collect(Collectors.toList());
    
        if (filteredCars.isEmpty()) {
            System.out.println("No cars found with a maximum price of: $" + maxPrice);
        } else {
            System.out.println("Cars with a maximum price of $" + maxPrice + ":");
            for (Price car : filteredCars) {
                System.out.println("Make: " + car.getBrand() +
                        ", Model: " + car.getModel() +
                        ", Type: " + car.getType() +
                        ", Year: " + car.getYear() +
                        ", Min Price: $" + car.getMinPrice() +
                        ", Max Price: $" + car.getMaxPrice());
            }
        }
    }
    
    public void searchByType(List<Car> cars, String carType) {
        List<Car> filteredCars = cars.stream()
                .filter(car -> car.getType().equalsIgnoreCase(carType)) 
                .collect(Collectors.toList());
    
        if (filteredCars.isEmpty()) {
            System.out.println("No cars found of type: " + carType);
        } else {
            System.out.println("Cars of type " + carType + ":");
            for (Car car : filteredCars) {
                System.out.println("Make: " + car.getBrand() +
                        ", Model: " + car.getModel() +
                        ", Year: " + car.getYear());
            }
        }
    }
        
    private static final Scanner scanner = new Scanner(System.in);
    //private static String selectedCarDetails = null; 

    /* 
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private CarSearchApplication carSearchApplication;
    */

    public static void main(String[] args) {
        CarSear carSearch = new CarSear();
        //EmailSenderService emailSenderService=new EmailSenderService();
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("Welcome to the Car Selection System!");
            System.out.println("1. Log in\n2. Register\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String username = "";
            String password = "";

            if (choice == 1) {
                System.out.print("Enter your username: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = scanner.nextLine();

                if (!carSearch.loginUser(username, password)) {
                    System.out.println("Login failed. Please try again.");
                    continue;
                }
            } else if (choice == 2) {
                System.out.print("Enter a new username: ");
                username = scanner.nextLine();
                System.out.print("Enter a password: ");
                password = scanner.nextLine();

                if (!carSearch.registerUser(username, password)) {
                    System.out.println("Registration failed. Please try again.");
                    continue;
                }

                System.out.println("Registration successful! Please log in.");
                continue;
            }  else if (choice == 3) {
                System.out.println("Exiting the system...");
                exitProgram = true;
                continue;
            } else {
                System.out.println("Invalid option. Please choose again.");
                continue;
            }

            List<Car> carList = carSearch.loadCarsFromCSV("CarData.csv");

            boolean searchAgain = true;
            while (searchAgain) {
                System.out.println("\n--- Car Search Options ---");
                System.out.println("1. Search by Brand");
                System.out.println("2. Search by Performance");
                System.out.println("3. Search by Safety");
                System.out.println("4. Search by Luxury");
                System.out.println("5. Search by Latest");
                System.out.println("6. Search by Maximum Price");
                System.out.println("7. Search by Type");
                System.out.println("8. Select a Car");
                System.out.println("9. View Selected Car");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");
                int searchOption = scanner.nextInt();
                scanner.nextLine();

                switch (searchOption) {
                    case 1:
                        System.out.print("Enter car brand: ");
                        String brand = scanner.nextLine();
                        carSearch.searchByBrand(brand, carList);
                        break;
                    case 2:
                        carSearch.searchByPerformance(carList);
                        break;
                    case 3:
                        carSearch.searchBySafety(carList);
                        break;
                    case 4:
                        carSearch.displayTop10LuxuryCars(carList);
                        break;
                    case 5:
                        carSearch.displayTop10LatestModels(carList);
                        break;
                    case 6:
                        System.out.print("Enter the Maximum price: ");
                        double minPrice = scanner.nextDouble();
                        carSearch.searchByMaxPrice(carList, minPrice);
                        break;
                    case 7:
                        System.out.print("Enter car type (e.g., SUV, Sedan,HatchBack etc): ");
                        String carType = scanner.nextLine();
                        carSearch.searchByType(carList, carType);
                        break;
                    case 8:
                        carSearch.selectCar(username, scanner);
                        System.out.println("Would u Like to Send your Details to your Email(yes/no)");
                        String toknow=scanner.next();
                        if(toknow.equalsIgnoreCase("yes")){
                            SpringApplication.run(CarSear.class, args);
                        }
                        break;

                    case 9:
                        carSearch.viewSelectedCar(username);
                        break;
                    case 10:
                        searchAgain = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            System.out.println("\nWould you like to continue using the system?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Choose an option: ");
            int continueChoice = scanner.nextInt();
            scanner.nextLine();

            if (continueChoice == 2) {
                System.out.println("Thank you for using the Car Selection System!");
                exitProgram = true;
            }
        }
        scanner.close();
    }
}