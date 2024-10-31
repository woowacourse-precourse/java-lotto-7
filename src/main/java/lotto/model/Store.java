package lotto.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Store {
    private final int PRICE_OF_LOTTO = 1000;
    public List<Lotto> sellLottos(Money money, int numOfLotto) {
        money.take(numOfLotto * PRICE_OF_LOTTO);
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<numOfLotto; i++) {
            lottos.add(new Lotto(createNumbers()));
        }
        return lottos;
    }
    public List<Integer> createNumbers() {
        return pickUniqueNumbersInRange(1,45,6);
    }
}