package lotto.controller;

import lotto.model.LottoTickets;
import lotto.view.LottoGameInputView;

public class LottoGameController {

    public void run() {
        LottoTickets lottoTickets = new LottoTickets(LottoGameInputView.inputMoney());

    }
}
