package lotto.utils;

import lotto.error.LottoErrorMessage;
import lotto.model.lotto.Lotto;
import lotto.constants.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class DrawNumbersValidator {

    private static final String DELIMITER = ",";

    public List<Integer> validateWinningNumbers(String winningNumbers) {
        validateEmpty(winningNumbers);
        validateWinningNumbersFormat(winningNumbers);

        List<String> splitWinningNumbers = List.of(winningNumbers.split(DELIMITER));
        validateCountWinningNumbers(splitWinningNumbers);
        validateAllNoLetters(splitWinningNumbers);
        validateDuplicateWiningNumbers(splitWinningNumbers);
        validateAllRange(splitWinningNumbers);
        return numbersToList(splitWinningNumbers);
    }

    public int validateBonusNumber(String bonusNumber) {
        validateEmpty(bonusNumber);
        validateNoLetters(bonusNumber);
        int parseBonusNumber = Integer.parseInt(bonusNumber);
        validateRange(bonusNumber);

        return parseBonusNumber;
    }

    public void validateAssociateWinningAndBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_WINNING_AND_BONUS_NUMBERS.getMessage());
        }
    }

    private void validateAllRange(List<String> splitWinningNumbers) {
        for (String number : splitWinningNumbers) {
            validateRange(number);
        }
    }

    private void validateAllNoLetters(List<String> splitWinningNumbers) {
        for (String number : splitWinningNumbers) {
            validateNoLetters(number);
        }
    }

    private void validateRange(String number) {
        if (Integer.parseInt(number) < LottoNumber.MIN_VALUE || LottoNumber.MAX_VALUE < Integer.parseInt(number)) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicateWiningNumbers(List<String> splitWinningNumbers) {
        if (isDuplicateWinningNumbers(splitWinningNumbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateNoLetters(String number) {
        if (!number.matches(LottoNumber.FORMAT)) {
            throw new IllegalArgumentException(LottoErrorMessage.LETTERS_IN_NUMBERS.getMessage());
        }
    }

    private void validateCountWinningNumbers(List<String> splitWinningNumbers) {
        if (splitWinningNumbers.size() < Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoErrorMessage.INSUFFICIENT_WINNING_NUMBERS.getMessage());
        }

        if (splitWinningNumbers.size() > Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWinningNumbersFormat(String winningNumbers) {
        if (winningNumbers.startsWith(DELIMITER) || winningNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(LottoErrorMessage.WRONG_WINNING_NUMBERS_FORMAT.getMessage());
        }
    }

    private void validateEmpty(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(LottoErrorMessage.EMPTY_NUMBERS.getMessage());
        }
    }

    private boolean isDuplicateWinningNumbers(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream().distinct().count() != splitWinningNumbers.size();
    }

    private List<Integer> numbersToList(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
