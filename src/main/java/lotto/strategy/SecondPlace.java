package lotto.strategy;

import java.util.List;
import java.util.Map;

public class SecondPlace implements PlaceAuction {

    private static final Integer SECOND_PLACE = 2;
    private static final Integer THIRD_PLACE = 3;

    private final Map<Integer, Integer> placeMap;
    private final List<Integer> bonusResult;

    public SecondPlace(Map<Integer, Integer> placeMap, List<Integer> bonusResult) {
        this.placeMap = placeMap;
        this.bonusResult = bonusResult;
    }

    @Override
    public void add(Integer count) {
        if (bonusResult.get(count).equals(1)) {
            placeMap.put(SECOND_PLACE, placeMap.get(SECOND_PLACE) + 1);
            return;
        }
        placeMap.put(THIRD_PLACE, placeMap.get(THIRD_PLACE) + 1);
    }
}
