package lotto.validator;

import static lotto.message.ExceptionMessage.DUPLICATE;
import static lotto.message.ExceptionMessage.ONLY_NUMBER;
import static lotto.message.ExceptionMessage.OUT_OF_RANGE;

import java.util.List;

public class NumberValidator {
    private static final Integer MIN = 1;
    private static final Integer MAX = 45;

    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ONLY_NUMBER.getMessage());
        }
    }

    public void isNumber(List<String> number) {
        for(String s : number) {
                isNumber(s);
        }
    }

    public void checkInRange(Integer value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    public void isDuplicateNumber(List<Integer> number) {
        if(number.size() != number.stream().distinct().count())
            throw new IllegalArgumentException(DUPLICATE.getMessage());
    }
}
