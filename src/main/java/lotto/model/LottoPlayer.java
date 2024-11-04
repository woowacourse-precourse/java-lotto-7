package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPlayer {

    private List<Lotto> autoNumbers = new ArrayList<>();

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
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
