package lotto.util;

import java.util.EnumMap;
import lotto.message.Place;
import lotto.message.Prize;

public class PrizeMoneyCalculator {

    private static final EnumMap<Place, Long> prize = Prize.getPrize();

    public static Long getPrizeMoney(EnumMap<Place, Long> places) {
        long prizeMoney = 0;
        for (Place place : Place.values()) {
            prizeMoney += places.get(place) * prize.get(place);
        }
        return prizeMoney;
    }
}
