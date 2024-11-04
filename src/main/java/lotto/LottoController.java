package lotto;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoGenerator lottoGenerator;
    private final LottoResultCalculator calculator;

    public LottoController(LottoGenerator lottoGenerator, LottoResultCalculator calculator) {
        this.lottoGenerator = lottoGenerator;
        this.calculator = calculator;
    }

    public void run() {
        // Step 1: 구입 금액 입력 및 로또 티켓 생성
        int purchaseAmount = InputView.requestPurchaseAmount();

        // Step 2: 티켓 개수에 맞게 로또 생성
        List<Lotto> lottos;
        try {
            lottos = lottoGenerator.generateLottos(purchaseAmount);
            OutputView.printPurchaseCount(lottos.size());
            OutputView.printLottoNumbers(lottos);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 3: 당첨 번호 입력
        List<Integer> winningNumbers;
        try {
            winningNumbers = InputView.requestWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 4: 보너스 번호 입력
        int bonusNumber;
        try {
            bonusNumber = InputView.requestBonusNumber(winningNumbers);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 5: 로또 결과 계산
        Map<Rank, Integer> statistics = calculator.calculateStatistics(lottos, winningNumbers, bonusNumber);
        double roi = calculator.calculateROI(statistics, purchaseAmount);

        // Step 6: 로또 결과 출력
        OutputView.printLottoResults(statistics, roi);
    }
}
