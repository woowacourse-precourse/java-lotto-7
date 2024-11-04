package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HandleException {
    public static boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }
}
