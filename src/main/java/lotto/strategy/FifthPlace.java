package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FifthPlace implements PlaceAuction {

    private final EnumMap<Place, Integer> placeMap;

    public FifthPlace(EnumMap<Place, Integer> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(Place.FIFTH_PLACE, placeMap.get(Place.FIFTH_PLACE) + 1);
    }
}
