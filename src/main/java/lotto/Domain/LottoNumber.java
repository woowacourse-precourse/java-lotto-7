package lotto.Domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoNumber {
    private List<Integer> numbers;

    public List<Integer> generateNumbers() {
        return new Random()
                .ints(LottoRange.LOTTO_LOWEST_NUMBER,
                        LottoRange.LOTTO_HIGHEST_NUMBER)
                .distinct()
                .limit(7)
                .boxed()
                .collect(Collectors.toList());
    }

    public LottoNumbers() {
        List<Integer> numbers = generateNumbers();
    }
}

