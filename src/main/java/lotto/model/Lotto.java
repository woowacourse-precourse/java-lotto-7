package lotto.model;

import static lotto.exception.LottoErrorStatus.INVALID_LOTTO_SIZE;
import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_DUPLICATED;
import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> lottoNumbers = new ArrayList<>(numbers);
        lottoNumbers.sort(Integer::compareTo);
        validate(lottoNumbers);
        this.numbers = lottoNumbers;
    }


    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_LOTTO_SIZE);
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        int beforeDistinct = numbers.size();
        Set<Integer> distincted = new HashSet<>(numbers);
        int afterDistinct = distincted.size();
        if (beforeDistinct != afterDistinct) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> (number < 1 || number > 45))) {
            throw new LottoException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
}
