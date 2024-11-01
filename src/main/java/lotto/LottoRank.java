package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BLANK(2, 0);

    private final int correctCount;
    private final int price;

    LottoRank(int correctCount, int price) {
        this.correctCount = correctCount;
        this.price = price;
    }

    public static LottoRank findByCorrectCountAndBonusBall(int correctCount, boolean bonusBall) {
        LottoRank rottoRank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.correctCount == correctCount)
                .findAny()
                .orElse(BLANK);

        if (rottoRank == THIRD && bonusBall) {
            return SECOND;
        }
        return rottoRank;
    }

    public String getCondition() {
        String condition = correctCount + "개 일치";

        if (this == LottoRank.SECOND) {
            condition += ", 보너스 볼 일치";
        }
        return condition;
    }

    public int getPrice() {
        return price;
    }
}
