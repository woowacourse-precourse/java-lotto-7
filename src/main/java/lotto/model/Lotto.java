package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessage;
import lotto.util.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberSizeIn(numbers);
        validateNumberDuplicationIn(numbers);
        validateNumberOutOfRangeIn(numbers);
    }

    private void validateNumberOutOfRangeIn(List<Integer> numbers) {
        for (int num : numbers) {
            LottoValidator.validateNumberRange(num);
        }
    }

    private void validateLottoNumberSizeIn(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_IS_NOT_FIT_SIZE.getMsg());
        }
    }

    private void validateNumberDuplicationIn(List<Integer> numbers) {
        Set<Integer> duplication = new HashSet<>(numbers);
        if (duplication.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }

    public List<Integer> lottoNums() {
        return Collections.unmodifiableList(numbers);
    }
}
