package lotto.strategy;

import java.util.Map;

public class FourthPlace implements PlaceAuction {

    private static final Integer FOURTH_PLACE = 4;

    private final Map<Integer, Integer> placeMap;

    public FourthPlace(Map<Integer, Integer> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(FOURTH_PLACE, placeMap.get(FOURTH_PLACE) + 1);
    }
}
