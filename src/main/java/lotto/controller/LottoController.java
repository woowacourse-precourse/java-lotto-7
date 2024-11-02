package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.Service;
import lotto.view.OutputLottosView;

public class LottoController {

    private final OutputLottosView outputLottosView;

    public LottoController() {
        this.outputLottosView = new OutputLottosView();
    }

    public static List<Lotto> lottoController(int amount) {
        int tickets = Service.purchaseTickets(amount);
        List<Lotto> lottos = Service.lottos(tickets);
        outputTickets(tickets);
        outputLottos(lottos);
        return lottos;
    }

    public static void outputTickets(int tickets) {
        OutputLottosView.outputTickets(tickets);
    }

    public static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            OutputLottosView.outputLottos(lotto.lottoValue());
        }
    }

}
