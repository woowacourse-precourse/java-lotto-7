package lotto.util;

import java.util.List;

public class MathUtil {
    private MathUtil() {
    }

    public static int getMatchCount(List<Integer> firstList, List<Integer> secondList) {
        int matchCount = (int) firstList.stream()
                .flatMap(i -> secondList.stream().filter(j -> i == j))
                .count();
        return matchCount;
    }
}
