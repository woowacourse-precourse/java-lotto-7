package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lottos {
    public Lotto createLotto() {
        List<Integer> randomNumbers = getRandomNumbers();
        return new Lotto(randomNumbers);
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
