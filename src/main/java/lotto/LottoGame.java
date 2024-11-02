package lotto;

import lotto.controller.LottoController;

public class LottoGame {
    public static void start() {
        LottoController lottoController = new LottoController();
        lottoController.crateLottoTicket();
    }
}
