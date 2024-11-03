package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottosService;
import lotto.service.TicketsService;
import lotto.view.OutputLottosView;

public class LottoController {

    private final OutputLottosView outputLottosView;

    public LottoController() {
        this.outputLottosView = new OutputLottosView();
    }

    public List<Lotto> setLottos(int amount) {
        int tickets = TicketsService.purchaseTickets(amount);
        List<Lotto> lottos = LottosService.lottos(tickets);
        outputTickets(tickets);
        outputLottos(lottos);
        return lottos;
    }

    private static void outputTickets(int tickets) {
        OutputLottosView.outputTickets(tickets);
    }

    private static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            OutputLottosView.outputLottos(lotto.lottoValue());
        }
    }

}
