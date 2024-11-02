package lotto.domain.model;

import java.util.List;
import lotto.exception.LottoSizeException;

public class Lotto {

    private static final int FIX_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != FIX_SIZE) {
            throw new LottoSizeException(FIX_SIZE);
        }
    }
}
