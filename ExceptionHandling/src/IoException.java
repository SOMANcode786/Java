import java.util.Scanner;

public class IoException {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the first name:");
            String firstName = sc.nextLine(); // Directly read input

            System.out.println("Enter the last name:");
            String lastName = sc.nextLine();

            System.out.println("Full Name: " + firstName + " " + lastName);
        } catch (Exception e) { // General exception handling
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            sc.close(); // Close the scanner to avoid resource leaks
        }
    }
}
