import java.util.Scanner;

public class Numbers {
    // Static variable to store the input array
    static int[] arrayInput;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = input.nextInt();

        arrayInput = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            arrayInput[i] = input.nextInt();
        }

        System.out.println("Enter the value of K:");
        int k = input.nextInt();

        findTopKFrequentNumbers(k);
    }

    // Static method to find top K frequent numbers
    public static void findTopKFrequentNumbers(int K) {
        int[] frequencies = new int[1000]; // Assuming the input numbers are within a reasonable range

        for (int num : arrayInput) {
            frequencies[num]++;
        }

        for (int i = 0; i < K; i++) {
            int maxFreq = -1;
            int maxFreqNum = -1;

            for (int j = 0; j < frequencies.length; j++) {
                if (frequencies[j] > maxFreq || (frequencies[j] == maxFreq && j > maxFreqNum)) {
                    maxFreq = frequencies[j];
                    maxFreqNum = j;
                }
            }

            if (maxFreqNum != -1) {
                System.out.print(maxFreqNum + " ");
                frequencies[maxFreqNum] = -1; // Mark as processed
            }
        }
    }
}


   
