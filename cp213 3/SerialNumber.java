package cp213;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Afolabi Awogbemi 200615200
 * @version 2022-09-23
 */
public class SerialNumber {

    /**
     * Determines if a string contains all digits.
     *
     * @param str The string to test.
     * @return true if str is all digits, false otherwise.
     */
    public static boolean allDigits(final String str) {

    	for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a string is a good serial number. Good serial numbers are of
     * the form 'SN/nnnn-nnn', where 'n' is a digit.
     *
     * @param sn The serial number to test.
     * @return true if the serial number is valid in form, false otherwise.
     */
    public static boolean validSn(final String sn) {

    	if (sn == null || sn.isEmpty()) {
            return false;
        }
        if (sn.length() != 11) {
            return false;
        }
        if (sn.startsWith("SN/")) {
            return allDigits(sn.substring(3, 7)) && allDigits(sn.substring(8));
        }
        return false;
    }

    /**
     * Evaluates serial numbers from a file. Writes valid serial numbers to
     * good_sns, and invalid serial numbers to bad_sns.
     *
     * @param fileIn  a file already open for reading
     * @param goodSns a file already open for writing
     * @param badSns  a file already open for writing
     */
    public static void validSnFile(final Scanner fileIn, final PrintStream goodSns, final PrintStream badSns) {

    	 while (fileIn.hasNext()) {
             String sn = fileIn.next();
             if (validSn(sn)) {
                 goodSns.println(sn);
             } else {
                 badSns.println(sn);
             }
         }
     }

}
