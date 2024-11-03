package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberMachine {

    private RandomNumberMachine() {}

    public static List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
