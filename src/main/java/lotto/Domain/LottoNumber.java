package lotto.Domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        return new Random()
                .ints(LottoRange.LOTTO_LOWEST_NUMBER.getValue(),
                        LottoRange.LOTTO_HIGHEST_NUMBER.getValue())
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}


