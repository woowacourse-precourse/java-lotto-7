package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
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

    public void buyLotto() {
        String money = inputView.inputMoney();
        lottoService.buyLotto(money);
    }

    public void printLottoNumbers() {
        List<Lotto> lottos = lottoService.getAllLottos();
        outputView.printPurchaseCount(lottos.size());
        outputView.printLottoNumbers(lottos);
    }

    public void checkLotto() {
        String winnerNumbers = inputView.inputWinnerNumbers();
        String bonusNumber = inputView.inputBonusNumber();
        lottoService.checkLotto(winnerNumbers, bonusNumber);
    }

    public void printWinningStatistics() {
        // Todo 당첨 통계 계산 서비스 호출
        String profitRate = "0";
        outputView.printWinningStatistics();
        outputView.printProfitRate(profitRate);
    }

    public void startLottoGame() {

        buyLotto();
        printLottoNumbers();
        checkLotto();
        printWinningStatistics();
    }
}
