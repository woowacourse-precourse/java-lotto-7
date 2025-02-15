package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.dto.LottoWinningNumbersDTO;
import lotto.utils.Message;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = Collections.unmodifiableList(winningNumbers);
        this.bonusNumber = bonusNumber;
        validate(winningNumbers, bonusNumber);
    }

    private void validate(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningLotto(winningNumbers);
        validateBonusNumbers(bonusNumber);
    }

    private void validateWinningLotto(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicatesNumber(numbers);
    }

    private void validateBonusNumbers(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateWinningNumber(bonusNumber);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicatesNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DUPLICATES_NUMBER.getMessage());
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_NUMBERS_RANGE.getMessage());
        }
    }

    private void validateDuplicateWinningNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    Message.DEFAULT_HEADER.getMessage() + Message.INVALID_DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    public int countMatches(Lotto lotto) {
        return lotto.countMatchingNumbers(winningNumbers);
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }

    public LottoWinningNumbersDTO toDto() {
        return new LottoWinningNumbersDTO(winningNumbers, bonusNumber);
    }
}
