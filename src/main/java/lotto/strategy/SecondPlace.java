package lotto.strategy;

import java.util.List;
import java.util.Map;
import lotto.message.Place;

public class SecondPlace implements PlaceAuction {

    private static final Integer SECOND_PLACE = 2;
    private static final Integer THIRD_PLACE = 3;
    private static final Integer TRUE = 1;

    private final Map<Integer, Integer> placeMap;
    private final List<Integer> bonusResult;

    public SecondPlace(Map<Integer, Integer> placeMap, List<Integer> bonusResult) {
        this.placeMap = placeMap;
        this.bonusResult = bonusResult;
    }

    @Override
    public void add(Integer count) {
        if (IsEqualToTrue(bonusResult.get(count))) {
            placeMap.put(SECOND_PLACE, placeMap.get(SECOND_PLACE) + 1);
            return;
        }
        placeMap.put(THIRD_PLACE, placeMap.get(THIRD_PLACE) + 1);
    }

    private boolean IsEqualToTrue(Integer bonus) {
        return bonus.equals(TRUE);
    }
}
