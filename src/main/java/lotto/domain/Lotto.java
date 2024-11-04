package lotto.domain;

import lotto.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (validateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 없어야 합니다.");
        }
        if(validateSizeNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45이하여야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
    public boolean contains(Integer number) {
        return numbers.contains(number);
    }
    private boolean validateSizeNumber(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number <= LottoConstants.INPUT_MIN_LOTTO || number > LottoConstants.INPUT_MAX_LOTTO) {
                return true;
            }
        }
        return false;
    }
    private boolean validateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
