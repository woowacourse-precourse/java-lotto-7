package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuyLotto {
    private final ArrayList<List<Integer>> dataUserLotto;

    public BuyLotto(Money money) {
        inputView inputView = new inputView();
        money = inputView.getMoney();
        ArrayList<List<Integer>> dataUserLotto = makeLottoList(money);
        this.dataUserLotto = dataUserLotto;
    }

    private ArrayList<List<Integer>> makeLottoList(Money money) {
        int moneyValue = money.getMoneyValue();
        int times = moneyValue / 1000;
        ArrayList<List<Integer>> dataUserLotto = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            List<Integer> lottoTimes = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTimes.sort(Comparator.naturalOrder());
            dataUserLotto.add(lottoTimes);
            System.out.println(lottoTimes);
        }
        System.out.println(dataUserLotto);
        return dataUserLotto;
    }
}
