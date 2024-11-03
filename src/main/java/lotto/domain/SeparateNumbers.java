package lotto.domain;

import java.util.Arrays;
import java.util.List;


public class SeparateNumbers {
    public List<Integer> separateInputNumbers(String inputNumbers) {

        return Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
