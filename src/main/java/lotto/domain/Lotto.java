package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.service.LottoMachine;
import lotto.util.ErrorMessage;
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
        if (numbers.size() != LottoMachine.LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_OUT_OF_RANGE.getMsg());
        }
    }

    private void validateNumberDuplicationIn(List<Integer> numbers) {
        Set<Integer> duplication = new HashSet<>(numbers);
        if (duplication.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int num) { return numbers.contains(num); }
}
