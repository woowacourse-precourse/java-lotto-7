package lotto.validation;

import java.util.List;
import static lotto.constatnt.LottoConstants.LOTTO_NUMBER_SIZE;
import static lotto.constatnt.LottoConstants.LOTTO_MIN_NUMBER;
import static lotto.constatnt.LottoConstants.LOTTO_MAX_NUMBER;
import lotto.constatnt.ExceptionMessage;

public class WinningNumberValidator extends BaseValidator {

    private List<Integer> winningNumbers;

    public void validateNumberIsEmpty(String winningLottoNumber) {
        if (winningLottoNumber == null || winningLottoNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    public void validateNumbers(List<Integer> lottoNumbers) {
        checkBlankInput(lottoNumbers);
        checkSize(lottoNumbers, LOTTO_NUMBER_SIZE);
        checkRange(lottoNumbers);
        checkDuplicates(lottoNumbers);
        this.winningNumbers = lottoNumbers;
    }

    public void validateBonusNumber(String bonusNumber) {
        checkIfBonusBlank(bonusNumber);
        int number = parseNumber(bonusNumber);
        checkRangeBonus(number);
        checkDuplicateWithWinning(number, winningNumbers);
    }

    private void checkBlankInput(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_BLANK_INPUT.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LOTTO_MIN_NUMBER || n > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private void checkIfBonusBlank(String bonusNumber) {
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

    private void checkRangeBonus(int number) {
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
