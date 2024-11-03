package lotto.strategy;

import java.util.EnumMap;
import lotto.message.Place;

public class FourthPlace implements PlaceAuction {

    private final EnumMap<Place, Long> places;

    public FourthPlace(EnumMap<Place, Long> places) {
        this.places = places;
    }

    @Override
    public void add(Integer count) {
        places.put(Place.FOURTH_PLACE, places.get(Place.FOURTH_PLACE) + 1);
    }
}
