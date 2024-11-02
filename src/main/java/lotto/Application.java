package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        try {
            // 1. 구입 금액 입력 및 로또 발행
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);

            // 구입한 로또 출력
            OutputView.printPurchasedLottos(purchasedLottos);

            // 2. 당첨 번호 입력
            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            Lotto winningLotto = new Lotto(winningNumbers);

            // 3. 보너스 번호 입력
            int bonusNumber = InputView.inputBonusNumber();  // 인자 제거

            // 4. 당첨 결과 계산
            Map<Rank, Long> results = lottoService.calculateResults(purchasedLottos, winningLotto, bonusNumber);

            // 당첨 통계 출력
            OutputView.printResults(results);

            // 5. 수익률 계산 및 출력
            double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
            OutputView.printProfitRate(profitRate);

        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
