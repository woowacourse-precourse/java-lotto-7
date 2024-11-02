package lotto.validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumberValidator implements Validator<String> {

    private static final String DELIMITER = ",";
    private static final int LOTTO_NUMBER_RANGE_MIN = 1;
    private static final int LOTTO_NUMBER_RANGE_MAX = 45;
    private static final int LOTTO_NUMBER_COUNTING = 6;

    @Override
    public boolean validate(String value) {
        if (isWinningNumbers(value)) {
            String[] values = value.split(DELIMITER);
            if (values.length != LOTTO_NUMBER_COUNTING) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 입니다.");
            }
            if (duplication(values)) {
                throw new IllegalArgumentException();
            }
            for (String input : values) {
                int number = isNumber(input.trim());
                oneBetweenFortyFive(number);
            }
            return true;
        }
        // BonusNumber Check
        isNumber(value);
        oneBetweenFortyFive(Integer.parseInt(value));

        return true;
    }

    private static void oneBetweenFortyFive(int number) {
        if (number < LOTTO_NUMBER_RANGE_MIN || number > LOTTO_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isWinningNumbers(String value) {
        return value.contains(DELIMITER);
    }

    private int isNumber(String value) {
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }

    private boolean duplication(String[] values) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, values);
        return set.size() != values.length;
    }


}
