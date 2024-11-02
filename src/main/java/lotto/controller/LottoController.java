package lotto.controller;

import lotto.model.Amount;
import lotto.model.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void purchase() {
        Amount amount = Amount.from(InputView.readLottoPurchaseAmount());
        LottoTicket ticket = LottoTicket.of(amount.getValue() / 1000);
        OutputView.printLottoCount(amount.getValue() / 1000);
        OutputView.printLottoTicket(ticket);
    }
}
