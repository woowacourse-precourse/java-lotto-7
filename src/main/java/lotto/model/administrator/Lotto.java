package lotto.model.administrator;

import static lotto.util.LottoConstant.LOTTO_NUMBER_END_WITH;
import static lotto.util.LottoConstant.LOTTO_NUMBER_START_WITH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.exception.administrator.LottoNumbersDuplicationException;
import lotto.exception.administrator.LottoNumbersMustBeSixException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;

/**
 * Lotto : 당첨 번호 (관리자가 입력)
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6 ||
                numbers.stream().anyMatch(Objects::isNull)) {
            throw new LottoNumbersMustBeSixException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> numbersToSet = new HashSet<>(numbers);
        if (numbersToSet.size() != numbers.size()) {
            throw new LottoNumbersDuplicationException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(c ->
                c < LOTTO_NUMBER_START_WITH.getNumber() ||
                        c > LOTTO_NUMBER_END_WITH.getNumber())) {
            throw new OutOfRangeLottoNumberException();
        }
    }
}
