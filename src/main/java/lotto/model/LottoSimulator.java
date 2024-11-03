package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {
    private final static int PRICE_OF_SINGLE_LOTTO = 1000;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int COUNT_OF_NUMBER = 6;
    private final int cost;
    private List<Lotto> purchasedLotto;

    public LottoSimulator(String cost) {
        this.cost = Integer.parseInt(cost);
        purchasedLotto = new ArrayList<>();
    }

    public void buyRandomLotto() {
        int count = cost / PRICE_OF_SINGLE_LOTTO;
        purchasedLotto.addAll(
                IntStream.range(0, count)
                        .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_NUMBER)))
                        .collect(Collectors.toList())
        );
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
