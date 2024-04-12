package April_12_Assignment;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Q1_Distinct_Number_Windows {
    public static int[] countDistinct(int[] A, int B) {
        if (B > A.length) {
            return new int[0]; // Return empty array if window size is greater than array size
        }

        int[] result = new int[A.length - B + 1];
        Map<Integer, Integer> window = new HashMap<>();
        int distinctCount = 0;

        // Initialize the count of distinct elements in the first window
        for (int i = 0; i < B; i++) {
            window.put(A[i], window.getOrDefault(A[i], 0) + 1);
            if (window.get(A[i]) == 1) {
                distinctCount++;
            }
        }

        result[0] = distinctCount;

        // Slide the window and update the count of distinct elements
        for (int i = B; i < A.length; i++) {
            // Remove the element going out of the window
            window.put(A[i - B], window.get(A[i - B]) - 1);
            if (window.get(A[i - B]) == 0) {
                distinctCount--;
            }

            // Add the new element entering the window
            window.put(A[i], window.getOrDefault(A[i], 0) + 1);
            if (window.get(A[i]) == 1) {
                distinctCount++;
            }

            result[i - B + 1] = distinctCount;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array A
        System.out.print("Enter the number of elements in the array: ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Input the window size B
        System.out.print("Enter the window size: ");
        int B = scanner.nextInt();

        // Calculate and print the count of distinct numbers in each window
        int[] result = countDistinct(A, B);
        System.out.println("Count of distinct numbers in each window:");
        System.out.println(Arrays.toString(result));
    }
}
