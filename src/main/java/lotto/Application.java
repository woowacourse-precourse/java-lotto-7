package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // Step 1: 구입 금액 입력 및 로또 티켓 생성
        int purchaseAmount = InputView.requestPurchaseAmount();

        // Step 2: 티켓 개수에 맞게 로또 생성
        LottoGenerator lottoGenerator = new LottoGenerator();
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
        LottoResultCalculator calculator = new LottoResultCalculator(lottos, winningNumbers, bonusNumber);
        Map<Rank, Integer> statistics = calculator.calculateStatistics();
        int totalPrize = calculator.calculateTotalPrize(statistics);
        double roi = calculator.calculateROI(totalPrize, purchaseAmount);

        // Step 6: 로또 결과 출력
        OutputView.printLottoResults(statistics, roi);
    }
}
