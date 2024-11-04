package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constatnt.ExceptionMessage;
import lotto.model.Lotto;

public class WinningNumberValidator {

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
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_SIZE_INSUFFICIENT.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 빈 값이 될 수 없습니다.");
        }
    }

    private int parseNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해주세요.");
        }
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicateWithWinning(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
