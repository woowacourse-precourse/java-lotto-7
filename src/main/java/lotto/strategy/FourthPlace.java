package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FourthPlace implements PlaceAuction {

    private final EnumMap<Place, Long> placeMap;

    public FourthPlace(EnumMap<Place, Long> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(Place.FOURTH_PLACE, placeMap.get(Place.FOURTH_PLACE) + 1);
    }
}
