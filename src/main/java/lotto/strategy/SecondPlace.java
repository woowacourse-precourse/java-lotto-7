package lotto.strategy;

import java.util.EnumMap;
import java.util.List;
import lotto.message.Place;

public class SecondPlace implements PlaceAuction {

    private static final Integer TRUE = 1;

    private final EnumMap<Place, Long> places;
    private final List<Integer> bonusResult;

    public SecondPlace(EnumMap<Place, Long> places, List<Integer> bonusResult) {
        this.places = places;
        this.bonusResult = bonusResult;
    }

    @Override
    public void add(Integer count) {
        if (IsEqualToTrue(bonusResult.get(count))) {
            places.put(Place.SECOND_PLACE, places.get(Place.SECOND_PLACE) + 1);
            return;
        }
        places.put(Place.THIRD_PLACE, places.get(Place.THIRD_PLACE) + 1);
    }

    private boolean IsEqualToTrue(Integer bonus) {
        return bonus.equals(TRUE);
    }
}
