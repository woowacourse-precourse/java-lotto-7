package util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultCalculator {
    private static final int THREE_MATCHES = 3;
    private static final int SIX_MATCHES = 6;
    private static final int FIVE_MATCHES_WITH_BONUS = -1;

    public static Map<Integer, Long> countMatchingResults(List<Integer> matchResultList) {
        return matchResultList.stream()
                .filter(count -> count >= THREE_MATCHES && count <= SIX_MATCHES || count == FIVE_MATCHES_WITH_BONUS)
                .collect(Collectors.groupingBy(count -> count, Collectors.counting()));
    }
}
