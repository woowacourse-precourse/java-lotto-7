package lotto.domain;

import static lotto.constants.Constants.MATCHING_COUNT_FIVE;
import static lotto.constants.Constants.MATCHING_COUNT_FOUR;
import static lotto.constants.Constants.MATCHING_COUNT_ONE;
import static lotto.constants.Constants.MATCHING_COUNT_SIX;
import static lotto.constants.Constants.MATCHING_COUNT_THREE;

public enum Winning {
    NO_WIN(0, 0),
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(7, 30000000),
    SIXTH(6, 2000000000);

    private final int label;
    private final int price;

    Winning(int label, int price) {
        this.label = label;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Winning findPrize(int matchCount, int bonusCount) {
        return getMatchingPrize(matchCount, bonusCount);
    }

    private static Winning getMatchingPrize(int matchCount, int bonusCount) {
        if (isSixthPrize(matchCount)) return SIXTH;
        if (isFifthWithBonusPrize(matchCount, bonusCount)) return FIFTH_WITH_BONUS;
        if (isFifthPrize(matchCount)) return FIFTH;
        if (isFourthPrize(matchCount)) return FOURTH;
        if (isThirdPrize(matchCount)) return THIRD;
        return NO_WIN;
    }

    private static boolean isSixthPrize(int matchCount) {
        return matchCount == MATCHING_COUNT_SIX;
    }

    private static boolean isFifthWithBonusPrize(int matchCount, int bonusCount) {
        return matchCount == MATCHING_COUNT_FIVE && bonusCount == MATCHING_COUNT_ONE;
    }

    private static boolean isFifthPrize(int matchCount) {
        return matchCount == MATCHING_COUNT_FIVE;
    }

    private static boolean isFourthPrize(int matchCount) {
        return matchCount == MATCHING_COUNT_FOUR;
    }

    private static boolean isThirdPrize(int matchCount) {
        return matchCount == MATCHING_COUNT_THREE;
    }
}
