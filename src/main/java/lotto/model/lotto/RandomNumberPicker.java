package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberPicker {
    public static List<Integer> pickAscendingNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
