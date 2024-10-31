package lotto.controller;

import lotto.Lotto;
import lotto.domain.Money;
import lotto.view.InputView;

public class LottoController {
    private Lotto lotto;
    private Money money;

    public LottoController() {
        this.money = new Money(InputView.inputMoney());
//        this.lotto = new Lotto(InputView.inputLottoNumbers());
    }

    public void set() {

    }
}
