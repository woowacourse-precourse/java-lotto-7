package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FifthPlace implements PlaceAuction {

    private final EnumMap<Place, Long> placeMap;

    public FifthPlace(EnumMap<Place, Long> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(Place.FIFTH_PLACE, placeMap.get(Place.FIFTH_PLACE) + 1);
    }
}
