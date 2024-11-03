package lotto.utils;

import lotto.model.lotto.Rank;

public class RankDescriptionGenerator {

    public static String makeDescription(Rank rank) {
        StringBuilder description = new StringBuilder();

        description.append(rank.getMatchingCount()).append("개 일치");
        appendConditionAboutBonusNumber(rank, description);
        appendInformationAboutPrizeMoney(rank, description);

        return description.toString();
    }

    private static void appendConditionAboutBonusNumber(Rank rank, StringBuilder description) {
        if (rank.isRequiresBonusMatch()) {
            description.append(", 보너스 볼 일치");
        }
    }

    private static void appendInformationAboutPrizeMoney(Rank rank, StringBuilder description) {
        description.append(" (")
                .append(String.format("%,d", rank.getPrizeMoney()))
                .append("원)");
    }
}
