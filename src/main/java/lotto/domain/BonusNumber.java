package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.exception.BonusNumberErrorMessage;

public class BonusNumber {

    private final int number;

    private static BonusNumber instance;

    private BonusNumber(String number) {
        this.number = validate(number);
    }

    public static BonusNumber getInstance() {
        return instance;
    }

    public static void initialInstance(String number) {
        if (instance == null) {
            instance = new BonusNumber(number);
        }
    }

    public static void resetInstance() {
        instance = null;
    }

    public int getNumber() {
        return number;
    }

    private int validate(String number) {
        int result = validateNumber(number);
        validateRange(result);
        validateDuplicate(result);

        return result;
    }

    private int validateNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.IS_NOT_POSSIBLE_RANGE.getMessage());
        }
    }

    private void validateDuplicate(int number) {
        Set<Integer> winningNumbers = new HashSet<>(WinningNumbers.getInstance().getWinningNumbers());

        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BonusNumberErrorMessage.IS_DUPLICATED_NUMBER.getMessage());
        }
    }
}
