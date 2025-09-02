package cp213;

/**
 * @author Afolabi Awogbemi 200615200
 * @version 2022-09-23
 */
public class Strings {
    // Constants
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Determines if string is a "palindrome": a word, verse, or sentence (such as
     * "Able was I ere I saw Elba") that reads the same backward or forward. Ignores
     * case, spaces, digits, and punctuation in the string parameter s.
     *
     * @param string a string
     * @return true if string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(final String string) {

	String newString = "";
    for (char c : string.toCharArray()) {
        if (Character.isLetter(c)) {
            newString += c;
        }
    }
    newString = newString.toLowerCase();
    String reverse = new StringBuffer(newString).reverse().toString();
    if (newString.equals(reverse))
    {
        return true;
    } else {	
    	return false;
    }
    }
    /**
     * Determines if name is a valid Java variable name. Variables names must start
     * with a letter or an underscore, but cannot be an underscore alone. The rest
     * of the variable name may consist of letters, numbers and underscores.
     *
     * @param name a string to test as a Java variable name
     * @return true if name is a valid Java variable name, false otherwise
     */
    public static boolean isValid(final String name) {

    char c = name.charAt(0);
    if (!(c >= 65 && c <= 90 || c >= 97 && c <= 122 || c == '_')) 
    {
        return false;
    }
    if (name.length() == 1 && c == '_')
    {
        return false;
    }
    for (int i = 0; i < name.length(); i++) {
        c = name.charAt(i);
        if (!(c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= '0' && c <= '9' || c == '_')) {
        	return false;
        }
    }
    return true;
  }

    /**
     * Converts a word to Pig Latin. The conversion is:
     * <ul>
     * <li>if a word begins with a vowel, add "way" to the end of the word.</li>
     * <li>if the word begins with consonants, move the leading consonants to the
     * end of the word and add "ay" to the end of that. "y" is treated as a
     * consonant if it is the first character in the word, and as a vowel for
     * anywhere else in the word.</li>
     * </ul>
     * Preserve the case of the word - i.e. if the first character of word is
     * upper-case, then the new first character should also be upper case.
     *
     * @param word The string to convert to Pig Latin
     * @return the Pig Latin version of word
     */
    public static String pigLatin(String word) {

    if (VOWELS.indexOf(word.charAt(0)) != -1)
    {
        return word + "way";
    }
    int len = word.length();
    int index = 0;	
    for (int i = 1; i < len; i++) {
        char c = word.charAt(i);
        if ((VOWELS.indexOf(c) != -1) || c == 'y' || c == 'Y') {
            index = i;
            break;
        }
    }
    String ans = word.substring(index) + word.substring(0, index) + "ay";
    if (Character.isUpperCase(word.charAt(0))) {
        ans = Character.toUpperCase(ans.charAt(0)) + ans.substring(1);
    }
    return ans;
    }
}
