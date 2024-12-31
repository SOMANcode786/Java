package mainApp;

import users.Administrator;
import users.Student;
import entities.Society;
import entities.Event;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Administrator and Student objects
        Administrator admin = new Administrator("A001", "AdminUser", "adminPass");
        Student student = new Student("67123", "JohnDoe");

        // Adding initial societies
        admin.addSociety(new Society("Tech Club", "A society for tech enthusiasts."));
        admin.addSociety(new Society("Drama Club", "For students passionate about theater."));
        admin.addSociety(new Society("Music Club", "Where music lovers unite."));

        while (true) {
            System.out.println("\n--- Student Society Management System ---");
            System.out.println("1. Login as Administrator");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                // Administrator login
                System.out.print("Enter Admin ID: ");
                String adminID = scanner.nextLine();
                System.out.print("Enter Admin Password: ");
                String adminPassword = scanner.nextLine();

                if (!admin.getUserID().equals(adminID) || !admin.validatePassword(adminPassword)) {
                    System.out.println("Invalid Admin ID or Password!");
                    continue;
                }

                admin.displayRole();

                while (true) {
                    System.out.println("\n--- Administrator Menu ---");
                    System.out.println("1. Add Society");
                    System.out.println("2. Delete Society");
                    System.out.println("3. List Societies");
                    System.out.println("4. Add Event to Society");
                    System.out.println("5. List Events in Society");
                    System.out.println("6. Logout");
                    System.out.print("Choose an option: ");
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (adminChoice) {
                        case 1 -> {
                            System.out.print("Enter Society Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Description: ");
                            String description = scanner.nextLine();
                            Society society = new Society(name, description);
                            admin.addSociety(society);
                        }
                        case 2 -> {
                            System.out.print("Enter Society Name to Delete: ");
                            String societyName = scanner.nextLine();
                            admin.deleteSociety(societyName);
                        }
                        case 3 -> admin.listSocieties();
                        case 4 -> {
                            System.out.print("Enter Society Name to Add Event: ");
                            String societyName = scanner.nextLine();
                            Society society = admin.findSocietyByName(societyName);
                            if (society == null) {
                                System.out.println("Society not found.");
                                break;
                            }

                            System.out.print("Enter Event Name: ");
                            String eventName = scanner.nextLine();
                            System.out.print("Enter Event Day: ");
                            int day = scanner.nextInt();
                            System.out.print("Enter Event Month: ");
                            int month = scanner.nextInt();
                            System.out.print("Enter Event Year: ");
                            int year = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            System.out.print("Enter Event Description: ");
                            String eventDescription = scanner.nextLine();

                            Event event = new Event(eventName, day, month, year, eventDescription);
                            society.addEvent(event);
                        }
                        case 5 -> {
                            System.out.print("Enter Society Name to List Events: ");
                            String societyName = scanner.nextLine();
                            Society society = admin.findSocietyByName(societyName);
                            if (society == null) {
                                System.out.println("Society not found.");
                                break;
                            }
                            society.listEvents();
                        }
                        case 6 -> {
                            System.out.println("Logging out...");
                            break;
                        }
                        default -> System.out.println("Invalid choice.");
                    }

                    if (adminChoice == 6) break;
                }
            } else if (choice == 2) {
                // Student login logic
                System.out.println("Student functionality not yet implemented.");
            } else {
                System.out.println("Exiting...");
                break;
            }
        }

        scanner.close();
    }
}
