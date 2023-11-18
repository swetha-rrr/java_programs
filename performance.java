import java.util.Scanner;

public class Performance {
    private int[] marks;

    public Performance() {
        marks = new int[10];
    }

    public void readMarks() {
    System.out.println("Enter marks for 10 students:");

    try (Scanner scanner = new Scanner(System.in)) {
        for (int i = 0; i < 10; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();

            // Validate marks (between 0 and 100)
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100.");
                System.out.print("Student " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
            }
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}


    public int highestMark() {
        int highest = marks[0];

 for (int i = 1; i < marks.length; i++) {
            if (marks[i] > highest) {
                highest = marks[i];
            }
        }

        return highest;
    }

    public int leastMark() {
        int least = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < least) {
                least = marks[i];
            }
        }

        return least;
    }

    public int getMode() {
        int mode = -1;
int maxFrequency = 0;

        for (int i = 0; i < marks.length; i++) {
            int currentMark = marks[i];
            int currentFrequency = 1;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] == currentMark) {
                    currentFrequency++;
                }
            }

            if (currentFrequency > maxFrequency || (currentFrequency == maxFrequency && currentMark > mode)) {
                mode = currentMark;
                maxFrequency = currentFrequency;
            }
        }

        return mode;
    }
public int getFreqAtMode() {
        int mode = getMode();
        int frequency = 0;

        for (int mark : marks) {
            if (mark == mode) {
                frequency++;
            }
        }

        return frequency;
    }

    public void display() {
        System.out.println("\nResults:");
        System.out.println("Highest Mark: " + highestMark());
        System.out.println("Least Mark: " + leastMark());
        System.out.println("Mode: " + getMode());
        System.out.println("Frequency at Mode: " + getFreqAtMode());
    }

    public static void main(String[] args) {
        Performance performance = new Performance();
        performance.readMarks();
        performance.display();
    }
}
