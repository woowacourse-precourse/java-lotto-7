package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constatnt.ExceptionMessage;

public class WinningNumberValidator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> winningNumbers;

    public void validateNumber(String winningLottoNumber) {
        if (winningLottoNumber == null || winningLottoNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    public void validateNumbers(List<Integer> lottoNumbers) {
        checkBlankInput(lottoNumbers);
        checkSize(lottoNumbers);
        checkRange(lottoNumbers);
        checkDuplicates(lottoNumbers);
        this.winningNumbers = lottoNumbers;
    }

    public void validateBonusNumber(String bonusNumber) {
        checkIfBlank(bonusNumber);
        int number = parseNumber(bonusNumber);
        checkRange(number);
        checkDuplicateWithWinning(number, winningNumbers);
    }

    private void checkBlankInput(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_SIZE_INSUFFICIENT.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void checkIfBlank(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    private int parseNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_NOT_NUMBER.getMessage());
        }
    }

    private void checkRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkDuplicateWithWinning(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING.getMessage());
        }
    }
}
