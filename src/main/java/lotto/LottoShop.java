package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.numberSelector.NumberSelector;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoShop {

    public static final int PRICE = 1000;
    public static final int START = 1;
    public static final int END = 45;
    public static final int COUNT = 6;

    public List<Lotto> buy(int money, NumberSelector selector) {
        List<Lotto> lottos = new ArrayList<>();

        int count = calNumOfLotto(money);
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            Lotto lotto = makeLotto(selector);
            System.out.println(lotto);
            lottos.add(lotto);
        }

        return lottos;
    }

    private int calNumOfLotto(int money) {
        //ignore the change(money % PRICE)
        return money / PRICE;
    }

    public WinningLotto setWinningLotto(List<Integer> numbers, int bonusNum) {
        return new WinningLotto(numbers, bonusNum);
    }

    private Lotto makeLotto(NumberSelector selector) {

        return new Lotto(selector.selectNumbers());
    }

}
