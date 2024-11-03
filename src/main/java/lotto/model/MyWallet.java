package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MyWallet {

    private final int money;
    private List<Lotto> lottos;
    private int winnings;
    

    public MyWallet(int money) {
        this.money = money;
        this.lottos = new ArrayList<>();
        this.winnings = 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    public int getWinnings() {
        return winnings;
    }

    public void buyLottos(int money) {
        List<Lotto> newLottos = LottoVendingMachine.issueNewLottos(money);
        lottos.addAll(newLottos);
    }


}
