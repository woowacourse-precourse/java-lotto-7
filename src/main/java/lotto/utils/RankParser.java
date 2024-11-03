package lotto.utils;

import java.util.HashMap;
import java.util.Map;
import lotto.model.lotto.Rank;

public class RankParser {

    public static Map<Rank, String> makeDescriptions() {
        Map<Rank, String> descriptions = new HashMap<>();

        for (Rank rank : Rank.values()) {
            descriptions.put(rank, makeDescription(rank));
        }

        return descriptions;
    }

    private static String makeDescription(Rank rank) {
        StringBuilder description = new StringBuilder();
        description.append(rank.getMatchingCount()).append("개 일치");

        if (rank.isRequiresBonusMatch()) {
            description.append(", 보너스 볼 일치");
        }

        description.append(" (")
                .append(String.format("%,d", rank.getPrizeMoney()))
                .append("원)");

        return description.toString();
    }
}
