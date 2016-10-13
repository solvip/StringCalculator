package is.ru.stringcalculator;

class Calculator {
    public static int add(String input) {
        if(input == "") {
            return 0;
        }

        int sum = 0;        
        for(String integer : input.split(",")) {
            sum += Integer.parseInt(integer);
        }

        return sum;
    }
}
