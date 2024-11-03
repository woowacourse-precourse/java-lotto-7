package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoTickets;
import lotto.model.RandomNumberGenerator;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGameController {

    public void run() {
        LottoTickets lottoTickets = new LottoTickets(LottoGameInputView.inputMoney());

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        List<Lotto> lottos = lottoMachine.exchangeLotto(lottoTickets);
        LottoGameOutputView.printLottos(lottos);
    }
}
