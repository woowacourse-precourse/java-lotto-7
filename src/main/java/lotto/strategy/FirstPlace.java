package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FirstPlace implements PlaceAuction {

    private final EnumMap<Place, Long> places;

    public FirstPlace(EnumMap<Place, Long> places) {
        this.places = places;
    }

    @Override
    public void add(Integer count) {
        places.put(Place.FIRST_PLACE, places.get(Place.FIRST_PLACE) + 1);
    }
}
