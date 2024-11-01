package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new ArrayList<>(numbers.subList(0, LOTTO_SIZE));
    }
}
