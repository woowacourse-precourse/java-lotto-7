package lotto.domain;

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
        return matchCount == 6;
    }

    private static boolean isFifthWithBonusPrize(int matchCount, int bonusCount) {
        return matchCount == 5 && bonusCount == 1;
    }

    private static boolean isFifthPrize(int matchCount) {
        return matchCount == 5;
    }

    private static boolean isFourthPrize(int matchCount) {
        return matchCount == 4;
    }

    private static boolean isThirdPrize(int matchCount) {
        return matchCount == 3;
    }
}
