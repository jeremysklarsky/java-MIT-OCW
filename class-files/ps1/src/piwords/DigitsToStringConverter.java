package piwords;

public class DigitsToStringConverter {
    /**
     * Given a list of digits, a base, and an mapping of digits of that base to
     * chars, convert the list of digits into a character string by applying the
     * mapping to each digit in the input.
     * 
     * If digits[i] >= base or digits[i] < 0 for any i, consider the input
     * invalid, and return null.
     * If alphabet.length != base, consider the input invalid, and return null.
     *
     * @param digits A list of digits to encode. This object is not mutated.
     * @param base The base the digits are encoded in.
     * @param alphabet The mapping of digits to chars. This object is not
     *                 mutated.
     * @return A String encoding the input digits with alphabet.
     */
        
    public static String convertDigitsToString(int[] digits, int base,
                                               char[] alphabet) {
        // TODO: Implement (Problem 3.b)
        char[] charMap = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

//      convert input to base 26
        int[] digitsArray = BaseTranslator.convertBase(digits, base, 26, digits.length);

//      map base26 to character
        char[] outputChars = new char[digits.length];
        
        for (int i = 0; i < digits.length; i++) {
            outputChars[i] = charMap[digitsArray[i]];
        }
        
        String output = new String(outputChars);
        
        return output;
    }
}
