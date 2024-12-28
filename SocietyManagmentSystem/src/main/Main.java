package main;

import models.*;
import Services.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocietyService societyService = new SocietyService();

        System.out.println("--- Welcome to the Student Society Management System ---");
        System.out.println("1. Login as Administrator");
        System.out.println("2. Login as Student");
        System.out.print("Choose an option: ");
        int accountType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (accountType == 1) {
            // Administrator Logic
            System.out.println("\n--- Administrator Login ---");
            System.out.print("Enter Admin ID: ");
            String adminID = scanner.nextLine();
            System.out.print("Enter Admin Username: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Enter Admin Password: ");
            String adminPassword = scanner.nextLine();

            Administrator admin = new Administrator(adminID, adminUsername, adminPassword);

            while (true) {
                System.out.println("\n--- Administrator Menu ---");
                System.out.println("1. Add Society");
                System.out.println("2. Delete Society");
                System.out.println("3. Display Societies");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Society ID: ");
                        String societyID = scanner.nextLine();
                        System.out.print("Enter Society Name: ");
                        String societyName = scanner.nextLine();
                        System.out.print("Enter Society Description: ");
                        String description = scanner.nextLine();

                        Society newSociety = new Society(societyID, societyName, description);
                        societyService.createSociety(admin, newSociety);
                        System.out.println("Society added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Society Name to Delete: ");
                        String societyToDelete = scanner.nextLine();
                        boolean isDeleted = societyService.deleteSociety(admin, societyToDelete);
                        if (isDeleted) {
                            System.out.println("Society deleted successfully!");
                        } else {
                            System.out.println("Society not found!");
                        }
                        break;

                    case 3:
                        societyService.displaySocieties(admin);
                        break;

                    case 4:
                        System.out.println("Exiting Administrator Menu...");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else if (accountType == 2) {
            // Student Logic
            System.out.println("\n--- Student Login ---");
            System.out.print("Enter Student ID: ");
            String studentID = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter Student Password: ");
            String studentPassword = scanner.nextLine();

            student student = new student(studentID, studentName, studentPassword);

            while (true) {
                System.out.println("\n--- Student Menu ---");
                System.out.println("1. View Societies");
                System.out.println("2. Join a Society");
                System.out.println("3. Check Membership Status");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        societyService.displaySocieties(null);
                        break;

                    case 2:
                        System.out.print("Enter Society Name to Join: ");
                        String societyToJoin = scanner.nextLine();
                        Society society = societyService.findSocietyByName(societyToJoin);
                        if (society != null) {
                            societyService.approveMembership(null, student, society);
                            System.out.println("Membership request sent!");
                        } else {
                            System.out.println("Society not found!");
                        }
                        break;

                    case 3:
                        student.viewMemberships();
                        break;

                    case 4:
                        System.out.println("Exiting Student Menu...");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid account type. Exiting...");
        }

        scanner.close();
    }
}
