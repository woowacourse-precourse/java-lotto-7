package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoPlayer {

    private List<Lotto> autoNumbers;

    public List<Lotto> purchase(int money) {
        int number = money / 1000;
        for (int i = 0; i < number; i++) {
            autoNumbers.add(chooseRandomNumbers());
        }
        return autoNumbers;
    }

    private Lotto chooseRandomNumbers() {
        List<Integer> numbers = randomNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
