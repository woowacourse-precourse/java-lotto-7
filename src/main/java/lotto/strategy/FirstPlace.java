package lotto.strategy;

import java.util.Map;

public class FirstPlace implements PlaceAuction {

    private static final Integer FIRST_PLACE = 1;

    private final Map<Integer, Integer> placeMap;

    public FirstPlace(Map<Integer, Integer> placeMap) {
        this.placeMap = placeMap;
    }

    @Override
    public void add(Integer count) {
        placeMap.put(FIRST_PLACE, placeMap.get(FIRST_PLACE) + 1);
    }
}
