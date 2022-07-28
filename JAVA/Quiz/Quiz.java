package Quiz;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array of 10 items
        String[] answerkey = { "b", "d", "a", "a", "c", "a", "a", "d", "b", "c" };
        int n = 0;

        int correct = 0;
        int incorrect = 0;
        String answer = "";

        for (int i = 0; i < 20; i++) {
            System.out.println("Please enter your answers. Acceptable input is limited to A,B,C,D. \n");
            answer = input.next();

            if (answer.compareTo(answerkey[0]) == 0) {
                correct++;
            } else {
                incorrect++;
            }
        }

        if (correct > 14) {
            System.out.println("You passed.");
        } else {
            System.out.println("You failed");
        }
        System.out.println("You have " + correct + " correct answers");
        System.out.println("You have " + incorrect + " incorrect answers");
    }
}