package lotto.model.lotto;

import static lotto.exception.LottoErrorStatus.INVALID_LOTTO_SIZE;
import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_DUPLICATED;
import static lotto.exception.LottoErrorStatus.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.model.constant.LottoRules.LOTTO_SIZE;
import static lotto.model.constant.LottoRules.MAX_LOTTO_VALUE;
import static lotto.model.constant.LottoRules.MIN_LOTTO_VALUE;

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
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException(INVALID_LOTTO_SIZE);
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        int beforeDeduplicate = numbers.size();
        Set<Integer> deduplicated = new HashSet<>(numbers);
        int afterDeduplicate = deduplicated.size();
        if (beforeDeduplicate != afterDeduplicate) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number ->
                (number < MIN_LOTTO_VALUE || number > MAX_LOTTO_VALUE))) {
            throw new LottoException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }
}
