package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author Afolabi Awogbemi
 * @version 2022-01-08
 */
public class ScannerTest {

    /**
     * Count lines in the scanned file.
     *
     * @param source Scanner to process
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {
	int count = 0;
	while (source.hasNextLine()) {
	    count++;
	    source.nextLine();
	}
	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;
	while (source.hasNext()) {
	    tokens++;
	    source.next();
	}
	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param source Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {
    int total = 0;
    System.out.println("Enter a series of integers. Press 'q' to quit.");
    // Read from the keyboard. n
    Scanner s = new Scanner(System.in);
    while (keyboard.hasNextInt()) {
        total += keyboard.nextInt();
    }
    s.close();
	return total;
    }


}
