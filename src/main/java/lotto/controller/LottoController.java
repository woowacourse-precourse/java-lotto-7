package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PrizeCount;
import lotto.domain.ProfitRate;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Amount amount = getPurchaseAmount();
        Lottos issuedLottos = lottoService.issueLottos(amount);
        outputView.displayIssuedLottos(issuedLottos);

        Lotto winningLotto = getWinningLotto();
        Bonus bonusNumber = getBonusNumber(winningLotto);

        PrizeCount prizeCount = lottoService.getPrizeCount(issuedLottos, winningLotto, bonusNumber);
        ProfitRate profitRate = lottoService.getProfitRate(amount, prizeCount);

        outputView.displayStatistics(prizeCount.getPrizeCount(), profitRate.getProfitRate());
    }

    private Amount getPurchaseAmount() {
        while (true) {
            try {
                inputView.printPurchaseAmountInputMessage();
                return Amount.of(inputView.getInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                inputView.printWinningNumberInputMessage();
                return Lotto.of(inputView.getInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Bonus getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                inputView.printBonusNumberInputMessage();
                return Bonus.of(inputView.getInput(), winningLotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
