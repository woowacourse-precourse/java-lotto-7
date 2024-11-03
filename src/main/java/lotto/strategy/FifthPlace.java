package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FifthPlace implements PlaceAuction {

    private final EnumMap<Place, Long> places;

    public FifthPlace(EnumMap<Place, Long> places) {
        this.places = places;
    }

    @Override
    public void add(Integer count) {
        places.put(Place.FIFTH_PLACE, places.get(Place.FIFTH_PLACE) + 1);
    }
}
