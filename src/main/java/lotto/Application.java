package lotto;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;
import lotto.domain.result.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            runGame(lottoService, inputView, outputView);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runGame(
            LottoService lottoService,
            InputView inputView,
            OutputView outputView) {
        int amount = inputView.readPurchaseAmount();
        Lottos lottos = lottoService.purchaseLottos(amount);
        outputView.printPurchaseResult(lottos);

        WinningLotto winningLotto = createWinningLotto(inputView);
        WinningResult result = lottoService.createWinningResult(lottos, winningLotto, amount);
        outputView.printWinningStatistics(result);
    }

    private static WinningLotto createWinningLotto(InputView inputView) {
        Lotto winningNumbers = (Lotto) inputView.readWinningNumbers();
        int bonusNumber = inputView.readBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}