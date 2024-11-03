package lotto;

import java.util.List;

public class LottoUser{

    private int money;
    private List<Lotto> purchasedLottos;

    public LottoUser(int money, List<Lotto> purchasedLottos) {
        this.money = money;
        this.purchasedLottos = purchasedLottos;
    }

    public static LottoUser create(int money, List<Lotto> purchasedLottos) {
        return new LottoUser(money, purchasedLottos);
    }
}
