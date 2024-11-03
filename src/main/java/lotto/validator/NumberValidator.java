package lotto.validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator implements Validator {

    private static final String ERROR = "[ERROR] ";
    private static final String DELIMITER = ",";
    private static final int WINNING_NUMBER_RANGE_MIN = 1;
    private static final int WINNING_NUMBER_RANGE_MAX = 45;
    private static final int WINNING_LENGTH = 6;
    private static final int BONUS_LENGTH = 7;

    private Set<String> winningNumbers;

    @Override
    public void validate(String input) {
        if (isWinningNumbers(input)) {
            String[] values = input.split(DELIMITER);
            if (values.length != WINNING_LENGTH) {
                throw new IllegalArgumentException(ERROR + "당첨 번호는 6자리 입니다.");
            }
            if (isDuplication(values)) {
                throw new IllegalArgumentException(ERROR + "당첨 번호는 중복되면 안됩니다.");
            }
            for (String value : values) {
                int number = isNumber(value.trim());
                isOneBetweenFortyFive(number);
            }
            return;
        }
        bonusNumberValidate(input);
    }

    private boolean isWinningNumbers(String input) {
        return input.contains(DELIMITER);
    }

    private boolean isDuplication(String[] values) {
        winningNumbers = new HashSet<>();
        Collections.addAll(winningNumbers, values);
        return winningNumbers.size() != values.length;
    }

    private int isNumber(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "양수만 입력가능합니다.");
        }
    }

    private void isOneBetweenFortyFive(int number) {
        if (number < WINNING_NUMBER_RANGE_MIN || number > WINNING_NUMBER_RANGE_MAX) {
            throw new IllegalArgumentException(ERROR + "1 ~ 45 사이의 숫자만 입력 가능합니다.");
        }
    }

    private void bonusNumberValidate(String input) {
        isNumber(input);
        isOneBetweenFortyFive(Integer.parseInt(input));
        winningNumbersDuplication(input);
    }

    private void winningNumbersDuplication(String input) {
        winningNumbers.add(input);
        if (winningNumbers.size() != BONUS_LENGTH) {
            throw new IllegalArgumentException(ERROR + "당첨 번호와 중복되면 안됩니다.");
        }
    }
}
