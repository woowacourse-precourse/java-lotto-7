package lotto.lotto;

import java.text.NumberFormat;
import java.util.Locale;

public enum Winners {

    NO_RANK("꽝", 0, 0),
    FIFTH_RANK("5등", 3, 5_000),
    FOURTH_RANK("4등", 4, 50_000),
    THIRD_RANK("3등", 5, 1_500_000),
    SECOND_RANK("2등", 5, 30_000_000),
    FIRST_RANK("1등", 6, 2_000_000_000);

    private final String description;
    private final int matchCount;
    private final int prize;

    Winners(String description, int matchCount, int prize) {
        this.description = description;
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public String formatResult(int count) {
        if (this == NO_RANK) {
            return "";
        }
        String matchInfo = getMatchCount() + "개 일치";
        if (this == SECOND_RANK) {
            matchInfo += ", 보너스 볼 일치";
        }
        return String.format("%s (%s원) - %d개", matchInfo, formatPrize(getPrize()), count);
    }

    public static Winners fromDescription(String description) {
        for (Winners winner : values()) {
            if (winner.description.equals(description)) {
                return winner;
            }
        }
        throw new IllegalArgumentException("[ERROR] 예기치 못한 에러가 발생했습니다.");
    }

    public static Winners determineRank(int matchCount, boolean hasBonus) {
        if (matchCount == 6) {
            return FIRST_RANK;
        }
        if (matchCount == 5 && hasBonus) {
            return SECOND_RANK;
        }
        if (matchCount == 5) {
            return THIRD_RANK;
        }
        if (matchCount == 4) {
            return FOURTH_RANK;
        }
        if (matchCount == 3) {
            return FIFTH_RANK;
        }
        return NO_RANK;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private static String formatPrize(int prize) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
        return formatter.format(prize);
    }

}