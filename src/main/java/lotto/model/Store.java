package lotto.model;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Store {
    public List<Integer> createNumbers() {
        return pickUniqueNumbersInRange(1,45,6);
    }
}