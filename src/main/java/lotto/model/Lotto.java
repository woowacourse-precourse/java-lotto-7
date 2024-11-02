package lotto.model;

import static lotto.constant.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberOutOfRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateDuplicateLottoNumber(numbers);
        validateLottoNumbersRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT));
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoNumberCountException();
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (countDistinctUniqueNumbers(numbers) != NUMBER_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(Integer number) {
        if (!isLottoNumberRange(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private long countDistinctUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
