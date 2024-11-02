package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberPicker {
    public static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
