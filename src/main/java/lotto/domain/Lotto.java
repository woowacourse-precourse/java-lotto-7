package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoDuplicateNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void validDuplicate(List<Integer> lotto) {
        Set<Integer> duplicateLottoNumber = lotto.stream()
                .filter(i -> Collections.frequency(lotto,i) > 1)
                .collect(Collectors.toSet());

        if (!duplicateLottoNumber.isEmpty()) {
            throw new LottoDuplicateNumberException(duplicateLottoNumber);
        }
    }

    public List<Integer> getLotto() {
        return new ArrayList<>(numbers);
    }

    public boolean checkContainsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
