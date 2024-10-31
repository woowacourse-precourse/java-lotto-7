package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.Money;
import lotto.util.SingletonObjectProvider;

public class LottoView {

    private final MoneyInputView moneyInputView;
    private final LottoController lottoController;

    public LottoView() {
        this.moneyInputView = SingletonObjectProvider.getSingletonObject(MoneyInputView.class);
        this.lottoController = SingletonObjectProvider.getSingletonObject(LottoController.class);
    }

    public void startLottoProgram() {
        Money money = moneyInputView.inputMoney();
    }
}