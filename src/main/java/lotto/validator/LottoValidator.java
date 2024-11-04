package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.enums.Constants;
import lotto.enums.ErrorMessages;

public class LottoValidator {

    static final String DELIMITER = ",";

    public static void validateInputMoney(String inputMoney) {
        isEmpty(inputMoney);
        isDigit(inputMoney);
        int money = Integer.parseInt(inputMoney);
        if (money % Constants.MONEY_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessages.MONEY_UNIT.getMessage(Constants.MONEY_UNIT.getValue()));
        }
    }

    public static void validateWinningNumbers(String inputWinningNumbers) {
        isEmpty(inputWinningNumbers);
        List<String> winningNumbers = Arrays.stream(inputWinningNumbers.split(DELIMITER)).toList();
        isLottoSize(winningNumbers);
        isUnique(winningNumbers);
        for (String winningNumber : winningNumbers) {
            isDigit(winningNumber);
            isInBound(winningNumber);
        }
    }

    public static void validateBonusNumber(String inputBonusNumber, List<Integer> winningNumbers) {
        isEmpty(inputBonusNumber);
        isDigit(inputBonusNumber);
        isInBound(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_UNIQUE_BONUS_NUMBER.getMessage());
        }
    }

    private static void isEmpty(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOTHING.getMessage());
        }
    }

    private static void isDigit(String inputString) {
        if (!inputString.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_FORMAT.getMessage());
        }
    }

    private static void isInBound(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < Constants.LOTTO_LOWER_BOUND.getValue() || number > Constants.LOTTO_UPPER_BOUND.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessages.LOTTO_BOUND.getMessage(Constants.LOTTO_LOWER_BOUND.getValue(),
                            Constants.LOTTO_UPPER_BOUND.getValue()));
        }
    }

    private static void isLottoSize(List<String> WinningNumbers) {
        if (WinningNumbers.size() != Constants.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(
                    ErrorMessages.LOTTO_SIZE.getMessage(Constants.LOTTO_NUMBER_SIZE.getValue()));
        }
    }

    private static void isUnique(List<String> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != Constants.LOTTO_NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessages.LOTTO_UNIQUE_WINNING_NUMBER.getMessage());
        }
    }
}