package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumbers;

public class Lottos {

    private List<Lotto> lottos;
    private final int lottoCount;

    public Lottos(int purchaseAmount) {
        this.lottos = new ArrayList<>();
        this.lottoCount = purchaseAmount/1000;
    }

    public Lotto createLotto() {
        List<Integer> numbers = RandomNumbers.generateRandomNumbers();
        Lotto lotto = new Lotto(numbers);
        lotto.sortNumbers(lotto.getNumbers());
        return lotto;
    }
}
