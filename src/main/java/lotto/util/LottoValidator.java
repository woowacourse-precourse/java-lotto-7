package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;

public final class LottoValidator {
    private static final String NUMBER_WITH_COMMA_PATTERN = "^[0-9,]+$";

    public static void validateNumbers(String input) {
        checkValidInputString(input);

        List<Integer> numbers = getNumberList(input);
        checkNumberCount(numbers);
        checkAllNumbersInRange(numbers);
        checkDuplicatedNumber(numbers);
    }

    private static void checkValidInputString(String input) {
        if (input == null || input.isEmpty() || !input.matches(NUMBER_WITH_COMMA_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_INPUT.format());
        }
    }

    private static List<Integer> getNumberList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_INPUT.format());
        }
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if(numbers.size() != 6){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_COUNT.format());
        }
    }

    private static void checkAllNumbersInRange(List<Integer> numbers) {
        for(int number : numbers){
            checkNumberInRange(number);
        }
    }

    private static void checkNumberInRange(int number) {
        if(number == 0 || number > 45){
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_BOUNDARY.format());
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.format());
        }
    }
}
