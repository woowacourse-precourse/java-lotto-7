package lotto.common;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> generateNumbersWithSizeAndRange(int startInclusive, int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            numbers.add(startInclusive + i);
        }

        return numbers;
    }
}
