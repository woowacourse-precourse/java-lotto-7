package lotto;

import java.util.Objects;

public class LottoResult {

    public static final int FIRST_PRIZE = 2_000_000_000;
    public static final int SECOND_PRIZE = 30_000_000;
    public static final int THIRD_PRIZE = 1_500_000;
    public static final int FOURTH_PRIZE = 50_000;
    public static final int FIFTH_PRIZE = 5000;

    private String rankName;
    private int sameNumerCount;

    public LottoResult(int sameNumberCount, boolean haveBonusNumber) {
        this.rankName = getRank(sameNumberCount, haveBonusNumber);
        this.sameNumerCount = sameNumberCount;
    }

    private String getRank(int sameNumberCount, boolean haveBonusNumber) {
        if (sameNumberCount == 6) {
            return "FIRST_PRIZE";
        }
        if (sameNumberCount == 5) {
            if (haveBonusNumber) {
                return "SECOND_PRIZE";
            }
            return "THIRD_PRIZE";
        }
        if (sameNumberCount == 4) {
            return "FOURTH_PRIZE";
        }
        return "FIFTH_PRIZE";
    }

    public int getPrize() {
        if (rankName.equals("FIRST_PRIZE")) {
            return FIRST_PRIZE;
        }
        if (rankName.equals("SECOND_PRIZE")) {
            return SECOND_PRIZE;
        }
        if (rankName.equals("THIRD_PRIZE")) {
            return THIRD_PRIZE;
        }
        if (rankName.equals("FOURTH_PRIZE")) {
            return FOURTH_PRIZE;
        }
        return FIFTH_PRIZE;
    }

    public String getRankName() {
        return rankName;
    }

    public int getSameNumberCount() {
        return sameNumerCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return sameNumerCount == that.sameNumerCount && Objects.equals(rankName, that.rankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankName, sameNumerCount);
    }
}
