package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

public class LottoNumberPicker {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int PICK_COUNT = 6;

    public static Lotto pickSortedRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, PICK_COUNT)
                .stream()
                .sorted()
                .toList();
        return new Lotto(numbers);
    }
}
