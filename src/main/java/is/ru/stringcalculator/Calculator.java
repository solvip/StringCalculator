package is.ru.stringcalculator;

public class Calculator {

    /**
     * Takes a string of comma or newline seperated integer values and returns their sum.
     * The empty string is equivalent to 0(what a crazy API)
     * @param input Comma or newline-seperated integer values
     * @return The sum of the input
     */
    public static int add(String input) {
        if(input == "") {
            return 0;
        }

        int[] values = parseIntegers(input);
        int sum = 0;
        for(int value : values) {
            sum += value;
        }

        return sum;
    }

    /* Parse the input string `input` into an array of integers */
    private static int[] parseIntegers(String input) {
        String[] splitInput = input.split("(,|\n)");
        int[] ret = new int[splitInput.length];

        for(int i = 0; i < splitInput.length; i++) {
            ret[i] = Integer.parseInt(splitInput[i]);
        }

        return ret;
    }
}
