package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        LottoController controller = new LottoController(lottoService);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<Lotto> lottos = controller.purchaseLottos(inputView.inputPurchaseAmount());
        resultView.printPurchaseResult(lottos);

        WinningLotto winningLotto = controller.createWinningLotto(
                inputView.inputWinningNumbers(),
                inputView.inputBonusNumber()
        );

        resultView.printWinningStatistics(controller.checkWinning(lottos, winningLotto));
        resultView.printProfitRate(controller.calculateProfitRate(lottos, winningLotto));
    }
}
