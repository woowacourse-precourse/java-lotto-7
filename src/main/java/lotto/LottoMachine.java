package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public List<Lotto> creatLotto(int amount) {
        int count = amountToCount(amount);

        lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }

        return lottos;
    }

    private int amountToCount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
