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
        try {
            int purchaseAmount = handlePurchaseAmountInput();  // Step 1: 구입 금액 입력 및 검증
            List<Lotto> lottos = handleLottoGeneration(purchaseAmount); // Step 2: 티켓 개수에 맞게 로또 생성
            List<Integer> winningNumbers = handleWinningNumbersInput(); // Step 3: 당첨 번호 입력 및 검증
            int bonusNumber = handleBonusNumberInput(winningNumbers); // Step 4: 보너스 번호 입력 및 검증
            handleLottoResults(lottos, winningNumbers, bonusNumber, purchaseAmount); // Step 5: 로또 결과 계산 및 출력
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private int handlePurchaseAmountInput() {
        OutputView.promptPurchaseAmount();
        String purchaseAmountInput = InputView.requestPurchaseAmount();
        try {
            return lottoService.validateAndParsePurchaseAmount(purchaseAmountInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return -1;
        }
    }

    private List<Lotto> handleLottoGeneration(int purchaseAmount) {
        List<Lotto> lottos = lottoService.generateLottos(purchaseAmount);
        OutputView.printPurchaseCount(lottos.size());
        OutputView.printLottoNumbers(lottos);
        return lottos;
    }

    private List<Integer> handleWinningNumbersInput() {
        OutputView.promptWinningNumbersInput();
        String winningNumbersInput = InputView.requestWinningNumbers();
        try {
            return lottoService.validateAndParseWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return null;
        }
    }

    private int handleBonusNumberInput(List<Integer> winningNumbers) {
        OutputView.promptBonusNumberInput();
        String bonusNumberInput = InputView.requestBonusNumber();
        try {
            return lottoService.validateAndParseBonusNumber(bonusNumberInput, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return -1;
        }
    }

    private void handleLottoResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber,
                                    int purchaseAmount) {
        Map<Rank, Integer> statistics = lottoService.calculateStatistics(lottos, winningNumbers, bonusNumber);
        double roi = lottoService.calculateROI(statistics, purchaseAmount);
        OutputView.printLottoResults(statistics, roi);
    }
}
