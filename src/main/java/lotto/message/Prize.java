package lotto.message;

import java.util.EnumMap;

public enum Prize {
    FIRST_PRIZE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PRIZE(1_500_000),
    FOURTH_PRIZE(50_000),
    FIFTH_PRIZE(5_000);

    private final Integer prizeMoney;

    Prize(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static EnumMap<Place, Integer> getPrize() {
        EnumMap<Place, Integer> prizes = new EnumMap<>(Place.class);
        prizes.put(Place.FIRST_PLACE, FIRST_PRIZE.prizeMoney);
        prizes.put(Place.SECOND_PLACE, SECOND_PLACE.prizeMoney);
        prizes.put(Place.THIRD_PLACE, THIRD_PRIZE.prizeMoney);
        prizes.put(Place.FOURTH_PLACE, FOURTH_PRIZE.prizeMoney);
        prizes.put(Place.FIFTH_PLACE, FIFTH_PRIZE.prizeMoney);
        return prizes;
    }
}
