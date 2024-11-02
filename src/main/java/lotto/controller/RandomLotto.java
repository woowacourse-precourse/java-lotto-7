package lotto.controller;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import lotto.util.ListSorter;

public class RandomLotto {
    public static List<Integer> generateRandomLotto() {
        List<Integer> randomLotto;
        randomLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        ListSorter sorter = new ListSorter();
        return sorter.ascending(randomLotto);
    }
}
