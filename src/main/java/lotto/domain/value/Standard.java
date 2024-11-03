package lotto.domain.value;

import java.util.Arrays;

public enum Standard {

    FIRST_PLACE(2_000_000_000, 6, false),
    SECOND_PLACE(30_000_000, 5, true),
    THIRD_PLACE(1_500_000, 5, false),
    FOURTH_PLACE(50_000, 4, false),
    FIFTH_PLACE(5_000, 3, false),
    EMPTY_PLACE(0, 0, false);

    private final int prizeMoney;
    private final int count;
    private final boolean isBonusNumberRequired;

    Standard(int prizeMoney, int count, boolean isBonusNumberRequired) {
        this.prizeMoney = prizeMoney;
        this.count = count;
        this.isBonusNumberRequired = isBonusNumberRequired;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isBonusNumberRequired() {
        return isBonusNumberRequired;
    }

    public boolean isCountMatches(int count) {
        return this.count == count;
    }

    public boolean checkCountMatches(int count, boolean hasBonusNumber) {

        if (!this.isCountMatches(count)) {
            return false;
        }

        return getPlaceConsideringBonus(hasBonusNumber);
    }

    public boolean getPlaceConsideringBonus(boolean hasBonusNumber) {
        if (!this.isCountMatches(SECOND_PLACE.getCount())) {
            return true;
        }

        return getPlaceByHasBonus(hasBonusNumber);
    }

    private boolean getPlaceByHasBonus(boolean hasBonusNumber) {
        return this.isBonusNumberRequired && hasBonusNumber;
    }

}
