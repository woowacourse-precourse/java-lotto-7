package lotto.model;

public class WinningCondition {

    public static final String NOT_ZERO_OR_POSITIVE_PRICE_EXCEPTION_MESSAGE =
            "우승조건에서 일치하는 번호가 음수인 경우는 허용하지 않습니다.";
    private final int matchedNumberCount;
    private final boolean isBonusNumberRequired;

    public WinningCondition(int matchedNumberCount, boolean isBonusNumberRequired) {
        validateZeroOrPositiveNumberCount(matchedNumberCount);
        this.matchedNumberCount = matchedNumberCount;
        this.isBonusNumberRequired = isBonusNumberRequired;
    }

    private void validateZeroOrPositiveNumberCount(int matchedNumberCount) {
        if (matchedNumberCount < 0) {
            throw new IllegalArgumentException(NOT_ZERO_OR_POSITIVE_PRICE_EXCEPTION_MESSAGE);
        }
    }

    public boolean checkWinning(int matchedNumberCount, boolean isBonusNumberMatched) {
        if (this.matchedNumberCount != matchedNumberCount) {
            return false;
        }
        if (this.isBonusNumberRequired) {
            return isBonusNumberMatched;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WinningCondition{" +
                "matchedNumberCount=" + matchedNumberCount +
                ", isBonusNumberRequired=" + isBonusNumberRequired +
                '}';
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isBonusNumberRequired() {
        return isBonusNumberRequired;
    }
}
