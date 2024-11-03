package lotto.strategy;

import java.util.EnumMap;
import java.util.List;
import lotto.message.Place;

public class SecondPlace implements PlaceAuction {

    private static final Integer TRUE = 1;

    private final EnumMap<Place, Long> placeMap;
    private final List<Integer> bonusResult;

    public SecondPlace(EnumMap<Place, Long> placeMap, List<Integer> bonusResult) {
        this.placeMap = placeMap;
        this.bonusResult = bonusResult;
    }

    @Override
    public void add(Integer count) {
        if (IsEqualToTrue(bonusResult.get(count))) {
            placeMap.put(Place.SECOND_PLACE, placeMap.get(Place.SECOND_PLACE) + 1);
            return;
        }
        placeMap.put(Place.THIRD_PLACE, placeMap.get(Place.THIRD_PLACE) + 1);
    }

    private boolean IsEqualToTrue(Integer bonus) {
        return bonus.equals(TRUE);
    }
}
