import java.util.Scanner;

public class Numbers{
    // Static variable to store the input array
    static int[] arrayInput;

    public static void main(String[] args)
 
{
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements: ");
        int n = input.nextInt();

        arrayInput = new int[n];
        System.out.println("Enter the elements of the array: ");

        for (int i = 0; i < n; i++) {
            arrayInput[i] = input.nextInt();
        }

        countFrequency(arrayInput, n);
    }

    public static void countFrequency(int[] arrayInput, int n)
 
{
        boolean[] visited = new
 
boolean[n];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < n; j++) {
                if (arrayInput[i] == arrayInput[j]) {
                    visited[j] = true;
                    count++;
                }
            }

            System.out.println(arrayInput[i] + " : " + count);
        }
    }

