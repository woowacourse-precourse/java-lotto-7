package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.model.Lotto;
import lotto.domain.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        // Step 1: 구입 금액 입력 및 검증
        OutputView.promptPurchaseAmount();
        String purchaseAmountInput = InputView.requestPurchaseAmount();
        int purchaseAmount;
        try {
            purchaseAmount = lottoService.validateAndParsePurchaseAmount(purchaseAmountInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 2: 티켓 개수에 맞게 로또 생성
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        OutputView.printPurchaseCount(lottos.size());
        OutputView.printLottoNumbers(lottos);

        // Step 3: 당첨 번호 입력 및 검증
        OutputView.promptWinningNumbersInput();
        String winningNumbersInput = InputView.requestWinningNumbers();
        List<Integer> winningNumbers;
        try {
            winningNumbers = lottoService.validateAndParseWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 4: 보너스 번호 입력 및 검증
        OutputView.promptBonusNumberInput();
        String bonusNumberInput = InputView.requestBonusNumber();
        int bonusNumber;
        try {
            bonusNumber = lottoService.validateAndParseBonusNumber(bonusNumberInput, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 5: 로또 결과 계산
        Map<Rank, Integer> statistics = lottoService.calculateStatistics(lottos, winningNumbers, bonusNumber);
        double roi = lottoService.calculateROI(statistics, purchaseAmount);

        // Step 6: 로또 결과 출력
        OutputView.printLottoResults(statistics, roi);
    }
}
