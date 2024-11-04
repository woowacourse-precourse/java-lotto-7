package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSorter {
    public static List<Integer> sort(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
