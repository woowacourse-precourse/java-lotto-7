package lotto.model;

import static lotto.constant.Constants.LOTTO_SIZE;

import java.util.List;
import lotto.message.ErrorMessage;
import lotto.validator.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.UNAVAILABLE_LOTTO_NUMBERS_LENGTH.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        InputValidator.hasDuplicateNumbers(numbers);
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(InputValidator::isLottoNumbersRangeIn);
    }

    public List<Integer> getLotto() {
        return numbers;
    }

    public LottoRank determineRank(WinningLotto winningLotto) {
        int matchCount = (int) numbers.stream()
                .filter(winningLotto.getWinningNumbers()::contains)
                .count();
        boolean matchBonusNumber = numbers.contains(winningLotto.getBonusNumber());

        return LottoRank.getRank(matchCount, matchBonusNumber);
    }
}
