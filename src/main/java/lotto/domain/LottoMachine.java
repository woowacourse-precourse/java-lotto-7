package lotto.domain;

import java.util.List;
import lotto.view.InputView;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoTicket;

    public LottoMachine() {
        amountValidate();
        this.lottoTicket = lottoTicket;
    }

    private void amountValidate() {
        int amount;

        while (true) {
            try {
                amount = InputView.inputPrice();
                canBuyLotto(amount);
                break;
            } catch (IllegalArgumentException e) {
                InputView.errorPrint(e.getMessage());
            }
        }
    }

    private void canBuyLotto(int amount) {
        if (!(amount >= LOTTO_PRICE)) {
            throw new IllegalArgumentException();
        }
        checkDivisible(amount);
    }

    private void checkDivisible(int amount) {
        if (!(amount / LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException();
        }
    }


}
