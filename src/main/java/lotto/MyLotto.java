package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoPrice.*;

public class MyLotto {
    private final List<Lotto> lottos;
    private final Lotto winPrice;
    private final int bonus;
    private final PriceStats priceStats;

    public MyLotto(Lotto winPrice, int bonus) {
        this.priceStats = new PriceStats();
        this.lottos = new ArrayList<>();
        this.winPrice = winPrice;
        this.bonus = bonus;
    }

    // 이를 통해서만 데이터 추가 가능
    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public PriceStats priceResult() {
        for (Lotto lotto : lottos) {
            isMatchLottoNumbers(lotto);
        }
        return priceStats;
    }

    private void isMatchLottoNumbers(Lotto lotto) {
        int cnt = 0;
        for (Integer number : winPrice.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                cnt++;
            }
        }
        if (cnt == FIRST.getMatch()) {
            priceStats.add(4);
            return;
        }
        if (cnt == SECOND.getMatch()) {
            isBonusNumber(lotto);
            return;
        }
        if (cnt == FOURTH.getMatch()) {
            priceStats.add(1);
            return;
        }
        if (cnt == FIFTH.getMatch()) {
            priceStats.add(0);
        }
    }

    private void isBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(bonus)) {
            priceStats.add(3);
            return;
        }
        priceStats.add(2);
    }
}
