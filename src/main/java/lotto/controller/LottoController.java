package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            int purchaseAmount = inputView.readPurchaseAmount(); // 구입 금액 입력
            List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount); // 로또 구매

            outputView.printLottoNumbers(purchasedLottos.size(), purchasedLottos); // 구매한 로또 티켓 출력

            Lotto winningLotto = inputView.readWinningNumbers(); // 당첨 번호 입력
            int bonusNumber = inputView.readBonusNumber(); // 보너스 번호 입력

            LottoResult result = lottoService.calculateResult(purchasedLottos, winningLotto, bonusNumber); // 당첨 결과 계산
            outputView.printLottoResults(result); // 결과 출력

            double totalProfitRate = lottoService.calculateProfitRate(purchaseAmount, result.getTotalPrize()); // 수익률 계산
            outputView.printTotalProfitRate(totalProfitRate); // 총 수익률 출력
        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.displayError(e.getMessage()); // 오류 메시지 출력
            run(); // 오류 발생 시 다시 실행
        }
    }
}
