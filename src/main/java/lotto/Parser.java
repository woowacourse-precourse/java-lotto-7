package lotto;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class Parser {
    public static int parseAmount(String input) {
        Validator.validateAmount(input);
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> parseUserPickNumbers(String input) {
        Validator.validateUserPickNumbers(input);
        ArrayList<Integer> numbers = parseNumbersByComma(input);
        return sortNumbers(numbers);
    }

    public static int parseUserPickBonus(String input, ArrayList<Integer> numbers) {
        Validator.validateUserPickBonus(input, numbers);
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> parseNumbersByComma(String input) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.stream(input.split(","))
                                                            .map(Integer::parseInt)
                                                            .collect(Collectors.toList()));
        return numbers;
    }

    public static ArrayList<Integer> sortNumbers(ArrayList<Integer> randomNumbers) {
        randomNumbers.sort(null);
        return randomNumbers;
    }
}