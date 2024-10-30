package lotto.Domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int LOTTO_LOWEST_NUMBER = 1;
    private static final int LOTTO_HIGHEST_NUMBER = 46;

    public List<Integer> generateNumbers() {
        return new Random()
                .ints(LOTTO_LOWEST_NUMBER, LOTTO_HIGHEST_NUMBER)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }
}

