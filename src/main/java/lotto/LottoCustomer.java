package lotto;

import java.util.List;

public class LottoCustomer {
    private int BetMoney;
    private List<Lotto> lottos;
    LottoCustomer() {
    }

    void addBetMoney(int betMoney) {
        this.BetMoney += betMoney;
    }

    void collectLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
