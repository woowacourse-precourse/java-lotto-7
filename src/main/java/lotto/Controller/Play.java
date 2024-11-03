package lotto.Controller;

import lotto.Controller.LottoController;
import lotto.Controller.MoneyController;
import lotto.Model.Lotto;;

public class Play {
    private final MoneyController moneyController;
    private final LottoController lottoController;

    public Play() {
        moneyController = new MoneyController();
        lottoController = new LottoController();
    }
}
