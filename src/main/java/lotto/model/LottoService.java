package lotto.model;

import lotto.view.MoneyInputView;

public class LottoService {

    private final MoneyInputView moneyInputView = new MoneyInputView();

    public int getMoney() {
        String inputMoney = moneyInputView.inputMoney();

        return Integer.parseInt(inputMoney);
    }
}
