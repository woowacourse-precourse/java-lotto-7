package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MyWallet {

    private int money;
    private final List<Lotto> lottos;
    private long winnings;


    public MyWallet() {
        this.money = 0;
        this.lottos = new ArrayList<>();
        this.winnings = 0;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getMoney() {
        return money;
    }

    public long getWinnings() {
        return winnings;
    }

    public void saveMoney(int money){
        this.money = money;
    }

    public void saveWinnings(long winnings){
        this.winnings = winnings;
    }

    public void buyLottos() {
        List<Lotto> newLottos = LottoVendingMachine.issueNewLottos(money);
        lottos.addAll(newLottos);
    }


}
