package lotto.domain;

import static lotto.domain.Lotto.LOTTO_SIZE;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000L, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000L, "3개 일치 (5,000원)"),
    NO_PRIZE(0, 0L, "낙첨");

    private static final int SECOND_AND_THIRD_MATCHED_NUMBER_COUNT = 5;

    private final int matchedNumberCount;
    private final Long price;
    private final String description;

    Rank(int matchedNumberCount, Long price, String description) {
        this.matchedNumberCount = matchedNumberCount;
        this.price = price;
        this.description = description;
    }

    public static Rank getRank(List<Integer> missedNumbers, int bonusNumber) {
        int matchedNumberCount = LOTTO_SIZE - missedNumbers.size();
        if (matchedNumberCount == SECOND_AND_THIRD_MATCHED_NUMBER_COUNT) {
            return determineSecondOrThird(missedNumbers, bonusNumber);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchedNumberCount() == matchedNumberCount)
                .findAny()
                .orElse(NO_PRIZE);
    }

    private static Rank determineSecondOrThird(List<Integer> missedNumbers, int bonusNumber) {
        if (missedNumbers.getFirst() == bonusNumber) {
            return SECOND;
        }
        return THIRD;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    private int getMatchedNumberCount() {
        return matchedNumberCount;
    }
}
