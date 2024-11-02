package lotto.strategy;

import java.util.Map;

public class FifthPlace implements PlaceAuction {

    private static final Integer FIFTH_PLACE = 5;

    private final Map<Integer, Integer> placeMap;

    public FifthPlace(Map<Integer, Integer> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(FIFTH_PLACE, placeMap.get(FIFTH_PLACE) + 1);
    }
}
