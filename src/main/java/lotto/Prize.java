package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST_PRIZE(6.0F),
    SECOND_PRIZE(5.5F),
    THIRD_PRIZE(5.0F),
    FOURTH_PRIZE(4.0F),
    FIFTH_PRIZE(3.0F);

    private Float matchingNumber;
    private Integer prizeMoney;

    Prize(Float matchingNumber) {
        this.matchingNumber = matchingNumber;
        setPrizeMoney();
    }

    public Float getMatchingNumber() {
        return matchingNumber;
    }
    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney() {
        if (matchingNumber == 6.0F)
            this.prizeMoney = 2000000000;
        if (matchingNumber == 5.5F)
            this.prizeMoney = 30000000;
        if (matchingNumber == 5.0F)
            this.prizeMoney = 1500000;
        if (matchingNumber == 4.0F)
            this.prizeMoney = 50000;
        if (matchingNumber == 3.0F)
            this.prizeMoney = 5000;
    }

    public static Prize findByMatchingNumber(float matchingNumber) {
        return Arrays.stream(Prize.values())
                .filter(result -> result.matchingNumber.equals(matchingNumber))
                .findFirst()
                .orElse(null);
    }
}
