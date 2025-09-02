package cp213;

/**
 * @author Afolabi Awogbemi 200615200
 * @version 2022-09-28
 */
public class Cipher {
    // Constants
    public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int ALPHA_LENGTH = ALPHA.length();

    /**
     * Encipher a string using a shift cipher. Each letter is replaced by a letter
     * 'n' letters to the right of the original. Thus for example, all shift values
     * evenly divisible by 26 (the length of the English alphabet) replace a letter
     * with itself. Non-letters are left unchanged.
     *
     * @param s string to encipher
     * @param n the number of letters to shift
     * @return the enciphered string in all upper-case
     */
    public static String shift(String s, int n) {

        String temp_string = "";
        s = s.toUpperCase();

        for(int i = 0; i<s.length(); i++) {

        	if(!Character.isLetter(s.charAt(i))==false) {
        		temp_string += (char)(((char)s.charAt(i)+n-65)%26+65);
        	}
        	else
        		temp_string += s.charAt(i);
        }
        return temp_string;
    }


    /**
     * Encipher a string using the letter positions in ciphertext. Each letter is
     * replaced by the letter in the same ordinal position in the ciphertext.
     * Non-letters are left unchanged. Ex:
     *
     * <pre>
    Alphabet:   ABCDEFGHIJKLMNOPQRSTUVWXYZ
    Ciphertext: AVIBROWNZCEFGHJKLMPQSTUXYD
     * </pre>
     *
     * A is replaced by A, B by V, C by I, D by B, E by R, and so on. Non-letters
     * are ignored.
     *
     * @param s          string to encipher
     * @param ciphertext ciphertext alphabet
     * @return the enciphered string in all upper-case
     */
    public static String substitute(String s, String ciphertext) {

        int t;
        String temp_string = "";
        s = s.toUpperCase();
        
        for(int i=0; i<s.length();i++) {
        	if(!Character.isLetter(s.charAt(i))==false) {
	        	char charc = s.charAt(i);
	        	for(t=0; t<ALPHA.length(); t++) {

	        		char Alpha = ALPHA.charAt(t);

	        		if(charc == Alpha) {
	        			int x = t;
	        			temp_string += ciphertext.charAt(x);
	        		}
	        	}
        	}
        	else {
        		temp_string += s.charAt(i);
        	}
        }
        
        return temp_string;

    }

}
