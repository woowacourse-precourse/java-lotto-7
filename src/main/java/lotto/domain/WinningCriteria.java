package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCriteria {
    private static final List<WinningCriteria> criteriaList = new ArrayList<>();
    private final int matchCount;
    private final boolean bonusMatchRequired;
    private final String label;
    private final int prize;

    private WinningCriteria(int matchCount, boolean bonusMatchRequired, String label, int prize) {
        this.matchCount = matchCount;
        this.bonusMatchRequired = bonusMatchRequired;
        this.label = label;
        this.prize = prize;
    }

    static {
        criteriaList.add(new WinningCriteria(6, false, "6개", 2_000_000_000));
        criteriaList.add(new WinningCriteria(5, true, "5개+보너스", 30_000_000));
        criteriaList.add(new WinningCriteria(5, false, "5개", 1_500_000));
        criteriaList.add(new WinningCriteria(4, false, "4개", 50_000));
        criteriaList.add(new WinningCriteria(3, false, "3개", 5_000));
    }

    public static WinningCriteria findMatchingCriteria(int matchCount, boolean bonusMatch) {
        for (WinningCriteria criteria : criteriaList) {
            if (criteria.matchCount == matchCount && criteria.bonusMatchRequired == bonusMatch) {
                return criteria;
            }
        }
        return null;
    }

    public static List<String> getAllLabels() {
        return criteriaList.stream()
                .map(WinningCriteria::getLabel)
                .collect(Collectors.toList());
    }

    public String getLabel() {
        return label;
    }

    public int getPrize() {
        return prize;
    }
}
