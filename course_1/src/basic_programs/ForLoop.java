package basic_programs;

import java.util.Scanner;

/**
 * @author cvoinea *
 * program to reverse an input number using for loop
 * TO DO: rewrite the program using recursion
 *
 * for (initialization; termination; increment) {
 *     statement(s)
 * }
 *
 * infinite loop
 * for ( ; ; ) { *
 *     // your code goes here
 * }
 *
 * can use enhanced-for statements
 */
public class ForLoop {

    public static void main(String[] args) {

        int inputNo;
        int reverseNo = 0;
        System.out.println("Input an int: ");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        /* for loop: No initialization part as inputNo is already
         * initialized and no increment/decrement part as logic
         * inputNo = inputNo/10 already decrements the value of inputNo
         */
        for (; inputNo != 0; ) {  // can update value here
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }

        System.out.println("Reverse of specified number is: " + reverseNo);

    }
}
