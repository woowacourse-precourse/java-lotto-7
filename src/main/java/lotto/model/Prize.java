package lotto.model;

import java.text.DecimalFormat;

public enum Prize {
    FIRST_PRIZE(1, 2_000_000_000, "6개 일치"),
    SECOND_PRIZE(2, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD_PRIZE(3, 1_500_000, "5개 일치"),
    FORTH_PRIZE(4, 50_000, "4개 일치"),
    FIFTH_PRIZE(5, 5_000, "3개 일치");

    public static final String FORMAT_OF_MONEY = "###,###";
    public static final String FORMAT_OF_STRING = "%s (%s원)";
    public final int rank;
    public final int jackpot;
    public final String description;

    Prize(int rank, int jackpot, String description) {
        this.rank = rank;
        this.jackpot = jackpot;
        this.description = description;
    }

    public static Prize findPrizeByRank(int rank) {
        if (rank == 1) {
            return Prize.FIRST_PRIZE;
        } else if (rank == 2) {
            return Prize.SECOND_PRIZE;
        } else if (rank == 3) {
            return Prize.THIRD_PRIZE;
        } else if (rank == 4) {
            return Prize.FORTH_PRIZE;
        } else if (rank == 5) {
            return Prize.FIFTH_PRIZE;
        }
        return null;
    }

    public static Prize findPrizeByCountAndBonus(int count, boolean bonus) {
        if (count == 6) {
            return Prize.FIRST_PRIZE;
        } else if (count == 5 && bonus) {
            return Prize.SECOND_PRIZE;
        } else if (count == 5) {
            return Prize.THIRD_PRIZE;
        } else if (count == 4) {
            return Prize.FORTH_PRIZE;
        } else if (count == 3) {
            return Prize.FIFTH_PRIZE;
        }
        return null;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_OF_MONEY);
        String formattedJackpot = decimalFormat.format(jackpot);
        return String.format(FORMAT_OF_STRING, description, formattedJackpot);
    }
}
