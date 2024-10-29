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
        int count = amount / LOTTO_PRICE;
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
        return count;
    }

}
