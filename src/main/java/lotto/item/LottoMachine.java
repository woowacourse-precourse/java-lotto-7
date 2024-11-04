package lotto.item;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.common.LottoInfo.*;

public class LottoMachine {
    private List<Lotto> lottos;

    public LottoMachine() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> buy(int money) {
        int amount = getAvailableLottoAmount(money);
        System.out.println("\n" + amount + "개를 구매했습니다.");
        for(int i=0; i<amount; i++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    public void showLottos() {
        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private int getAvailableLottoAmount(int money) {
        return money / LOTTO_PRICE;
    }

    private Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_SIZE));
    }
}