package lotto.controller;

import java.util.List;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.util.Config;
import lotto.view.InputHandler;
import lotto.view.Outputview;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = InputHandler.getValidMoney();
        lottoService.issueLottoTickets(money / Config.LOTTO_PRICE);
        Outputview.printLottoTickets(lottoService.getLottoTickets());

        List<Integer> winningNumbers = InputHandler.getValidWinningNumbers();
        int bonusNumber = InputHandler.getValidBonusNumber(winningNumbers);

        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        List<Rank> results = lottoService.calculateResults();
        Outputview.printResults(results);

        double yield = lottoService.calculateYield(money, results);
        Outputview.printYield(yield);
    }
}
