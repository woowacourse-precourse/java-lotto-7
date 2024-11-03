package lotto.utils;

import lotto.model.lotto.Rank;

public class RankDescriptionGenerator {

    public static String makeDescription(Rank rank) {
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
