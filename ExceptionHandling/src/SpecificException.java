import java.util.Scanner;

public class SpecificException {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try {
            // Read array size
            System.out.print("Enter the size of the array: ");
            int n = s.nextInt();
            int[] array = new int[n];

            // Populate the array
            for (int i = 0; i < n; i++) {
                System.out.print("Enter a number for position " + i + ": ");
                array[i] = s.nextInt();
            }

            // Display array elements
            System.out.println("Array elements are:");
            for (int i = 0; i < n; i++) {
                System.out.println("Position " + i + ": " + array[i]);
            }

            // Perform division operations
            System.out.println("Enter two indices to divide (k and l): ");
            int k = s.nextInt();
            int l = s.nextInt();

            // Validate indices
            if (k < 0 || k >= n || l < 0 || l >= n) {
                throw new ArrayIndexOutOfBoundsException("Invalid indices: k=" + k + ", l=" + l);
            }

            // Validate division by zero
            if (array[l] == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            int result = array[k] / array[l];
            System.out.println("Result of array[" + k + "] / array[" + l + "] = " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        } finally {
            s.close(); // Close the scanner in the `finally` block
        }
    }
}
