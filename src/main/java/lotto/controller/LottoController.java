package lotto.controller;

import lotto.model.Amount;
import lotto.model.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void purchase() {
        Amount amount = Amount.of(InputView.readLottoPurchaseAmount());
        LottoTicket ticket = LottoTicket.of(amount.getNumber() / 1000);
        OutputView.printLottoCount(amount.getNumber() / 1000);
        OutputView.printLottoTicket(ticket);
    }
}
