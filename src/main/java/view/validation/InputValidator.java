package view.validation;

import view.exception.LottoException;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String WINNING_NUMBER_REGEX = "^[0-9,\\s]+$";
    private static final String MONEY_REGEX = "\\d+";
    private static final String BONUS_NUMBER_REGEX = "\\d+";
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static int validateMoney(String money) {
        if (money == null || money.isBlank()) {
            throw new LottoException(InputErrorMessage.MONEY_EMPTY_MESSAGE.getMessage());
        }

        if (!money.matches(MONEY_REGEX)) {
            throw new LottoException(InputErrorMessage.MONEY_FORMAT_MESSAGE.getMessage());
        }

        int charge = Integer.parseInt(money);
        return charge;
    }

    public static List<Integer> validateWinningNumber(String winningNumber) {
        if (winningNumber == null || winningNumber.isBlank()) {
            throw new LottoException(InputErrorMessage.WINNING_NUMS_EMPTY_MESSAGE.getMessage());
        }

        if (!winningNumber.matches(WINNING_NUMBER_REGEX)) {
            throw new LottoException(InputErrorMessage.WINNING_NUMS_FORMAT_MESSAGE.getMessage());
        }

        List<Integer> winningNums = Arrays.stream(winningNumber.split(WINNING_NUMBER_DELIMITER))
                .map(String::strip)
                .peek(number -> {
                    if (number.isBlank()) {
                        throw new LottoException(InputErrorMessage.WINNING_NUMS_FORMAT_MESSAGE.getMessage());
                    }
                })
                .map(Integer::parseInt)
                .toList();

        return winningNums;
    }

    public static int validateBonusNumber(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new LottoException(InputErrorMessage.BONUS_NUM_EMPTY_MESSAGE.getMessage());
        }

        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new LottoException(InputErrorMessage.BONUS_NUM_FORMAT_MESSAGE.getMessage());
        }

        int bonusNum = Integer.parseInt(bonusNumber);
        return bonusNum;
    }
}
