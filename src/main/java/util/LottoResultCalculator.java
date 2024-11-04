package util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    public static Map<Integer, Long> countMatchingResults(List<Integer> matchResultList) {
        return matchResultList.stream()
                .filter(count -> count >= 3 && count <= 6)
                .collect(Collectors.groupingBy(count -> count, Collectors.counting()));
    }
}
