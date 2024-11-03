package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FirstPlace implements PlaceAuction {

    private final EnumMap<Place, Long> placeMap;

    public FirstPlace(EnumMap<Place, Long> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(Place.FIRST_PLACE, placeMap.get(Place.FIRST_PLACE) + 1);
    }
}
