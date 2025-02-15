package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
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
        return retry(inputView::inputBudget);
    }

    private List<Lotto> buyLottos(Budget budget) {
        List<Lotto> lottos = lottoService.buyLottos(budget);
        outputView.outputPurchasedLottoInfo(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto(Lotto winningNumber) {
        return retry(() -> {
            Bonus bonus = inputView.inputBonusNumber();
            return new WinningLotto(winningNumber, bonus);
        });
    }

    private Lotto inputWinningNumber() {
        return retry(inputView::inputWinningNumber);
    }

    private void showStatistics(WinningLotto winningLotto, List<Lotto> purchasedLotto) {
        MatchingResult matchingResult = lottoService.calculateMatchingResult(winningLotto, purchasedLotto);
        outputView.outputStatistics(matchingResult);
    }

    private <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
