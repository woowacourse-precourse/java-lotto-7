package lotto.model.draw;

import java.util.Arrays;

public enum Prize {

    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    BLANK();

    private final int count;

    Prize(int count) {
        this.count = count;
    }

    Prize() {
        this.count = 0;
    }

    public static Prize findPrize(int sameNumberCount, boolean isContainBonusNumber) {
        Prize prize = Arrays.stream(values())
                .filter(value -> sameNumberCount == value.getCount())
                .findFirst()
                .orElse(BLANK);

        if (prize.equals(SECOND) && !isContainBonusNumber) {
            prize = THIRD;
        }
        return prize;
    }

    public int getCount() {
        return count;
    }

}
