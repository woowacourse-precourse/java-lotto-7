package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;
import lotto.domain.Rank;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoGenerator lottoGenerator;
    private final LottoResultCalculator resultCalculator;

    public LottoController(LottoGenerator lottoGenerator, LottoResultCalculator resultCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.resultCalculator = resultCalculator;
    }

    public void run() {
        // Step 1: 구입 금액 입력 및 로또 티켓 생성
        OutputView.promptPurchaseAmount();
        String purchaseAmountInput = InputView.requestPurchaseAmount();
        String validationError = Validator.validatePurchaseAmount(purchaseAmountInput);
        if (validationError != null) {
            OutputView.printErrorMessage(validationError);
            return;
        }
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);

        // Step 2: 티켓 개수에 맞게 로또 생성
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        OutputView.printPurchaseCount(lottos.size());
        OutputView.printLottoNumbers(lottos);

        // Step 3: 당첨 번호 입력
        OutputView.promptWinningNumbersInput();
        String winningNumbersInput = InputView.requestWinningNumbers();
        List<Integer> winningNumbers;
        try {
            winningNumbers = Validator.validateWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 4: 보너스 번호 입력
        OutputView.promptBonusNumberInput();
        String bonusNumberInput = InputView.requestBonusNumber();
        int bonusNumber;
        try {
            bonusNumber = Validator.validateBonusNumber(bonusNumberInput, winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 5: 로또 결과 계산
        Map<Rank, Integer> statistics = resultCalculator.calculateStatistics(lottos, winningNumbers, bonusNumber);
        double roi = resultCalculator.calculateROI(statistics, purchaseAmount);

        // Step 6: 로또 결과 출력
        OutputView.printLottoResults(statistics, roi);
    }
}
