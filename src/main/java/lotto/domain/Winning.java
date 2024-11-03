package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Winning {

    private static final String DELIMITER = ",";

    private final Lotto lotto;

    public Winning(String input) {
        List<Integer> numbers = convertToIntegerList(input);
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        return lotto;
    }

    private List<Integer> convertToIntegerList(String input) {
        String[] inputSplit = input.split(DELIMITER);
        return Arrays.stream(inputSplit)
                .map(Integer::parseInt)
                .toList();
    }
}
