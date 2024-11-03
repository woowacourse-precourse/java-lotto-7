package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FirstPlace implements PlaceAuction {

    private static final Integer FIRST_PLACE = 1;

    private final EnumMap<Place, Integer> placeMap;

    public FirstPlace(EnumMap<Place, Integer> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(Place.FIRST_PLACE, placeMap.get(Place.FIRST_PLACE) + 1);
    }
}
