package lotto.lotto;

import static lotto.lotto.Lotto.LOTTO_SIZE;

import java.util.List;

public record WinningNumbers(List<LottoNumber> winningNumbers) {
    public WinningNumbers {
        validate(winningNumbers);
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.contains(number);
    }

    private void validate(List<LottoNumber> winningNumbers) {
        if (isSizeInvalid(winningNumbers)) {
            throw LottoException.INVALID_NUMBER_SIZE.getException();
        }

        if (hasDuplicatedNumber(winningNumbers)) {
            throw LottoException.DUPLICATED_NUMBER.getException();
        }
    }

    private boolean isSizeInvalid(List<LottoNumber> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplicatedNumber(List<LottoNumber> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE;
    }
}
