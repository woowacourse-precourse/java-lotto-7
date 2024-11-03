package lotto.message;

import java.util.EnumMap;

public enum Prize {
    FIRST_PRIZE(2_000_000_000L),
    SECOND_PLACE(30_000_000L),
    THIRD_PRIZE(1_500_000L),
    FOURTH_PRIZE(50_000L),
    FIFTH_PRIZE(5_000L);

    private final Long prizeMoney;

    Prize(Long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Long getPrizeMoney() {
        return prizeMoney;
    }

    public static EnumMap<Place, Long> getPrize() {
        EnumMap<Place, Long> prizes = new EnumMap<>(Place.class);
        prizes.put(Place.FIRST_PLACE, FIRST_PRIZE.prizeMoney);
        prizes.put(Place.SECOND_PLACE, SECOND_PLACE.prizeMoney);
        prizes.put(Place.THIRD_PLACE, THIRD_PRIZE.prizeMoney);
        prizes.put(Place.FOURTH_PLACE, FOURTH_PRIZE.prizeMoney);
        prizes.put(Place.FIFTH_PLACE, FIFTH_PRIZE.prizeMoney);
        return prizes;
    }
}
