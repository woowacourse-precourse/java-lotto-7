package lotto;

import lotto.controller.LottoController;
import lotto.service.Starter;
import lotto.service.LottoTickets;

public class Application {
    public static void main(String[] args) {
        LottoTickets lottoTickets = new LottoTickets();
        LottoController lottoController = new LottoController(lottoTickets);
        Starter lottoStarter = new Starter(lottoController);

        lottoStarter.run();
    }
}
