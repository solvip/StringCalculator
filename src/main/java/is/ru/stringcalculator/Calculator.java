package is.ru.stringcalculator;

import java.util.List;
import java.util.ArrayList;

public class Calculator {

    /**
     * Takes a string of comma or newline seperated integer values and returns their sum.
     * If the input string starts with "//<FOO>\n"; then <FOO> will be used as the delimiter instead
     * of comma/newline.
     * The empty string is equivalent to 0(what a crazy API)
     * @param input Comma, newline or custom delimiter-seperated integer values
     * @return The sum of the input
     */
    public static int add(String input) {
        if(input == "") {
            return 0;
        }

        int[] values = parseIntegers(input);
        validate(values);
        
        int sum = 0;
        for(int value : values) {
            if(value > 1000) {
                continue;
            }
            sum += value;
        }

        return sum;
    }
    
    /* Parse the input string `input` into an array of integers */
    private static int[] parseIntegers(String input) {
        String delimiter = "(,|\n)";

        /* If we have a custom delimiter, we parse it and advance input past it */
        if(input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEnd);
            input = input.substring(delimiterEnd+1);
        }
        

        String[] splitInput = input.split(delimiter);
        int[] ret = new int[splitInput.length];
        
        for(int i = 0; i < splitInput.length; i++) {
            ret[i] = Integer.parseInt(splitInput[i]);
        }

        return ret;
    }

    /* Validate the array of values; throw IllegalArgumentException if any are illegal */
    private static void validate(int[] values) throws IllegalArgumentException {
        List<String> illegalValues = new ArrayList<String>();
        for(int value : values) {
            if(value < 0) {
                illegalValues.add(Integer.toString(value));
            }
        }

        if(illegalValues.size() > 0) {
            String errmsg = String.format("Negatives not allowed: %s", String.join(",", illegalValues));
            throw new IllegalArgumentException(errmsg);
        }
    }
}
