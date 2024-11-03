package lotto.controller;

import lotto.domain.RandomLottos;
import lotto.domain.model.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoService lottoService;
    private final LottoInputView inputView;
    private final LottoOutputView outputView;

    public LottoController(LottoService lottoService, LottoInputView inputView, LottoOutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String priceInput = inputView.getPriceInput();
        int ticket = lottoService.changeToTicket(priceInput);

        outputView.printTicketGuide(ticket);
        RandomLottos randomLottos = lottoService.createRandomLottos(ticket);
        for (Lotto lotto : randomLottos.lottos()) {
            outputView.printNumbers(lotto.getNumbers());
        }

        String winningNumberInput = inputView.getWinningNumberInput();
        Lotto winningLottoNumbers = lottoService.createWinningLottoNumbers(winningNumberInput);
    }
}
