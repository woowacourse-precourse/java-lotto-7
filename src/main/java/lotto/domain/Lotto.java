package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
