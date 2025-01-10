import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        int[] marks = new int[5];
        Scanner S = new Scanner(System.in);

        try {
            // Taking input for the marks array
            for (int i = 0; i < marks.length; i++) {
                System.out.print("Enter number for index " + i + ": ");
                marks[i] = S.nextInt(); // This may throw InputMismatchException
            }
        } catch (Exception e) {
            // Catch general exceptions
            System.out.println("An error occurred: " + e.getMessage());
            System.out.println(e);
        } finally {
            S.close(); // Close the scanner
        }

        // Output the entered marks
        System.out.println("Marks entered:");
        for (int mark : marks) {
            System.out.println(mark);
        }
    }
}
