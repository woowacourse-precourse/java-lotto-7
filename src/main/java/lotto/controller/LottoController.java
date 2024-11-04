package lotto.controller;

import lotto.model.lotto.WinningLotto;
import lotto.model.lotto.lottoCollection;
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
        // 1. 구입 금액을 입력받고 로또 티켓을 생성
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottoCollection lottoCollection = lottoService.purchaseLottos(purchaseAmount);
        outputView.printPurchasedLottos(lottoCollection);

        // 2. 당첨 번호와 보너스 번호를 입력받아 WinningLotto 생성
        WinningLotto winningLotto = inputWinningLotto();

        // 3. 당첨 결과 계산 및 수익률 계산
        lottoService.calculateResults(lottoCollection, winningLotto);
        double earningsRate = lottoService.getEarningsRate(purchaseAmount);

        // 4. 결과 출력
        outputView.printResult(lottoService.getStatistics(), earningsRate);
    }

    private WinningLotto inputWinningLotto() {
        var winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
