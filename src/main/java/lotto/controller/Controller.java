package lotto.controller;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.MatchingResult;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Budget budget = inputBudget();
        List<Lotto> purchasedLottos = buyLottos(budget);

        Lotto winningNumber = inputWinningNumber();
        WinningLotto winningLotto = makeWinningLotto(winningNumber);

        showStatistics(winningLotto, purchasedLottos);
    }

    private Budget inputBudget() {
        try {
            return inputView.inputBudget();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBudget();
        }
    }

    private List<Lotto> buyLottos(Budget budget) {
        List<Lotto> lottos = lottoService.buyLottos(budget);
        outputView.outputPurchasedLottoInfo(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto(Lotto winningNumber) {
        try {
            Bonus bonus = inputBonusNumber();
            return new WinningLotto(winningNumber, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningLotto(winningNumber);
        }
    }

    private Lotto inputWinningNumber() {
        try {
            return inputView.inputWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private Bonus inputBonusNumber() {
        try {
            return inputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private void showStatistics(WinningLotto winningLotto, List<Lotto> purchasedLotto) {
        MatchingResult matchingResult = lottoService.calculateMatchingResult(winningLotto, purchasedLotto);
        outputView.outputStatistics(matchingResult);
    }
}
