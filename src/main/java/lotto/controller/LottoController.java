package lotto.controller;

import lotto.model.*;
import lotto.model.Number;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        LottoService service = new LottoService();
        WinningResult winningResult = new WinningResult();
        double profitRate;

        Amount amount = inputView.getAmount();
        outputView.displayCount(amount.toCount());
        service.issue(amount.toCount());
        List<Lotto> lottos = service.getLottos();
        outputView.displayLotto(lottos);

        Lotto winning = inputView.getWinning();
        Number bonus = inputView.getBonus();
        WinningNumbers winningNumbers = new WinningNumbers(winning, bonus);
        for (Lotto lotto : lottos) {
            winningResult.put(winningNumbers.getReward(lotto));
        }

        outputView.displayRank(winningResult);
        profitRate = winningResult.getProfitRate(amount);
        outputView.displayProfit(profitRate);

    }
}
