package lotto.model;

import static lotto.constants.ErrorMessage.LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE;
import static lotto.constants.LottoCondition.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoCondition.MIN_LOTTO_NUMBER;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateHasDuplicatedNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateHasDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(LOTTO_NUMBERS_CAN_NOT_BE_DUPLICATED.get());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer lottoNumber : numbers) {
            validateIsRangeOneToFortyFive(lottoNumber);
        }
    }

    private void validateIsRangeOneToFortyFive(Integer lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER.get() || lottoNumber > MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE.get());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lotto comparingLotto = (Lotto) obj;
        return Objects.equals(numbers, comparingLotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public List<Integer> get() {
        return numbers;
    }
}
