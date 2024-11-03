package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoRule.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getMatchNumberCount(List<Integer> numbers) {
        List<Integer> matchingNumbers = new ArrayList<>(numbers);
        matchingNumbers.retainAll(this.numbers);

        return matchingNumbers.size();
    }

    public Boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    public static List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }

    private boolean outOfNumberRange(Integer number) {
        return number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(this::outOfNumberRange)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d ~ %d 범위여야 합니다.", LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
        }
    }
}
