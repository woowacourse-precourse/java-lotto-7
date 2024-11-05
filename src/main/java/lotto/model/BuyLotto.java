package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.item.Money;

public class BuyLotto {
    private final List<List<Integer>> dataUserLotto;

    public BuyLotto(Money money) {
        this.dataUserLotto = makeLottoList(money);
    }

    public List<List<Integer>> getDataUserLotto() {
        return dataUserLotto;
    }

    private List<List<Integer>> makeLottoList(Money money) {
        int times = money.getMoneyValue() / 1000;
        List<List<Integer>> dataUserLotto = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            List<Integer> lottoTimes = new ArrayList<>
                    (Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoTimes.sort(Comparator.naturalOrder());
            dataUserLotto.add(lottoTimes);
        }
        return dataUserLotto;
    }
}