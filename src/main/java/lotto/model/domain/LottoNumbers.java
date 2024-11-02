package lotto.model.domain;

import java.util.List;
import lotto.model.ErrorMessage;

public class LottoNumbers {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);

        this.lottoNumbers =lottoNumbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctNumber = numbers.stream()
                .distinct()
                .count();
        if (distinctNumber != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public boolean hasNumber(int number) {
        return getNumbers().contains(number);
    }

    public int countDuplicatingNumbers(List<Integer> other) {
        return (int) getNumbers().stream()
                .filter(other::contains)
                .count();
    }
}
