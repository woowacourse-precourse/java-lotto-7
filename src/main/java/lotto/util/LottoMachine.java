package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> creatLotto(int amount) {
        int count = amountToCount(amount);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public Lotto createWinningLotto(List<Integer> winningNumbers) {

        Lotto lotto = new Lotto(winningNumbers);

        return lotto;
    }

    private int amountToCount(int amount) {
        int count = amount / LOTTO_PRICE;
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
        return count;
    }
}
