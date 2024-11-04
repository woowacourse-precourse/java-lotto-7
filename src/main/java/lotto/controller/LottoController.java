package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.LottoResultPrinter;
import lotto.view.LottoView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;
    private final LottoResultService lottoResultService;
    private final LottoResultPrinter lottoResultPrinter;
    private final LottoView lottoView;

    public LottoController() {
        this.inputView = new InputView();
        this.lottoService = new LottoService();
        this.lottoResultService = new LottoResultService();
        this.lottoResultPrinter = new LottoResultPrinter();
        this.lottoView = new LottoView();
    }


    public void run() {
        // 1. 구입 금액 입력 및 로또 발행
        long purchaseAmount = inputView.getPurchaseAmount();
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);

        // 2. 발행된 로또 번호 출력
        lottoView.printPurchasedLottos(lottos);

        // 3. 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        // 4. 당첨 결과 계산
        Map<Integer, Integer> resultCount = lottoResultService.calculateWinningResults(lottos, winningNumbers, bonusNumber);
        int totalPrize = lottoResultService.calculateTotalPrize(resultCount);

        // 5. 결과 출력
        lottoResultPrinter.printResult(resultCount, totalPrize, purchaseAmount);
    }
}
