package lotto.util.calculator;

import static lotto.value.Rank.FIFTH_PLACE;
import static lotto.value.Rank.FIRST_PLACE;
import static lotto.value.Rank.FOURTH_PLACE;
import static lotto.value.Rank.NO_RANK;
import static lotto.value.Rank.SECOND_PLACE;
import static lotto.value.Rank.THIRD_PLACE;

import java.util.HashMap;
import java.util.Map;
import lotto.value.LottoValue;
import lotto.value.Rank;

public class LottoWinningPlaceCalculator {

    public Rank calculate(int countMatching, boolean isMatchingBonus) {
        Map<Boolean, Rank> rankMap = new HashMap<>();
        rankMap.put(isFirstPlace(countMatching), FIRST_PLACE);
        rankMap.put(isSecondPlace(isMatchingBonus, countMatching), SECOND_PLACE);
        rankMap.put(isThirdPlace(isMatchingBonus, countMatching), THIRD_PLACE);
        rankMap.put(isFourthPlace(countMatching), FOURTH_PLACE);
        rankMap.put(isFifthPlace(countMatching), FIFTH_PLACE);
        return rankMap.getOrDefault(true, NO_RANK);
    }

    private boolean isFirstPlace(int countMatchingFirstPlaceNumbers) {
        return countMatchingFirstPlaceNumbers == LottoValue.NUMBER_COUNT.value();
    }

    private boolean isSecondPlace(
            boolean isBonus, int countMatchingNumber) {
        return (countMatchingNumber == SECOND_PLACE.getMatchCount()) && (isBonus);
    }

    private static boolean isThirdPlace(boolean isBonus, int countMatchingNumber) {
        return (countMatchingNumber == THIRD_PLACE.getMatchCount() && (!isBonus));
    }

    private static boolean isFourthPlace(int countMatchingNumber) {
        return countMatchingNumber == FOURTH_PLACE.getMatchCount();
    }

    private static boolean isFifthPlace(int countMatchingNumber) {
        return countMatchingNumber == FIFTH_PLACE.getMatchCount();
    }

}
