package lotto.controller;


import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoResult;
import lotto.model.domain.WinningLotto;
import lotto.model.service.LottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private List<Lotto> lottos;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            int amount = purchaseLottos();
            WinningLotto winningLotto = createWinningLotto();
            LottoResult result = lottoService.calculateResult(lottos, winningLotto);

            printResult(result, amount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            run();
        }
    }

    private int purchaseLottos() {
        int amount = InputView.readPurchaseAmount();
        lottos = lottoService.purchaseLottos(amount);

        OutputView.printPurchaseCount(lottos.size());
        lottos.forEach(OutputView::printLotto);

        return amount;
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void printResult(LottoResult result, int amount) {
        OutputView.printResult(result);
        OutputView.printProfitRate(result.calculateProfitRate(amount));
    }
}