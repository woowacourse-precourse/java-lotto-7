package lotto.validator;

import java.util.List;

public class NumberValidator {
    private static final String PREFIX = "[ERROR]";
    private static final String OUT_OF_RANGE_MESSAGE = PREFIX + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ONLY_NUMBER_MESSAGE = PREFIX + " 입력값은 숫자여야 합니다.";
    private static final String DUPLICATE_MESSAGE = PREFIX + " 로또 번호는 중복되는 숫자가 없어야 합니다.";

    private static final Integer MIN = 1;
    private static final Integer MAX = 45;

    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public void isNumber(List<String> number) {
        for(String s : number) {
                isNumber(s);
        }
    }

    public void checkInRange(Integer value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
    }

    public void isDuplicateNumber(List<Integer> number) {
        if(number.size() != number.stream().distinct().count())
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
    }
}
