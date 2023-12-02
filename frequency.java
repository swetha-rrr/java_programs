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
    output:
    Enter the number of stock prices: 5
Enter the stock prices:
23
45
67
54
12
Maximum Profit: 88


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

question 2:
import java.util.Scanner;

public class ShareTrader {
    private static int maxProfit1, maxProfit2;

    public static int findMaxProfit(int[] prices) {
        int n = prices.length;

        if (n < 2) {
            System.out.println("Not enough stock prices to trade.");
            return 0;
        }

        // Initialize variables to store the maximum profits
        maxProfit1 = 0;
        maxProfit2 = 0;
        int minBuy1 = Integer.MAX_VALUE, minBuy2 = Integer.MAX_VALUE;

        for (int price : prices) {
            // First transaction: Buy and sell
            minBuy1 = Math.min(minBuy1, price);
            maxProfit1 = Math.max(maxProfit1, price - minBuy1);

            // Second transaction: Buy and sell
            minBuy2 = Math.min(minBuy2, price - maxProfit1);  // Adjust the buying price
            maxProfit2 = Math.max(maxProfit2, price - minBuy2);
        }

        // Total maximum profit is the sum of profits from two transactions
        return maxProfit1 + maxProfit2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of stock prices
        System.out.print("Enter the number of stock prices: ");
        int n = scanner.nextInt();

        // Input the stock prices
        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Calculate and print the maximum profit
        System.out.println("Maximum Profit: " + findMaxProfit(prices));
    }
}


   
