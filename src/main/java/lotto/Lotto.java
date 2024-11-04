package lotto;

import lotto.common.LottoInfo;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.common.LottoInfo.*;
import static lotto.common.LottoInfo.LOTTO_END_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        duplicateValidate(numbers);
        isInRightRangeInInputNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> duplicateRemovedNumbers = new HashSet<>(numbers);
        if(duplicateRemovedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isInRightRangeInInputNumbers(List<Integer> numbers) {
        if(!numbers.stream().allMatch(i -> i>=LOTTO_START_NUMBER && i<=LOTTO_END_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}