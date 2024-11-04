package lotto.domain.numberPicker;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberPicker implements NumberPicker {

    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
