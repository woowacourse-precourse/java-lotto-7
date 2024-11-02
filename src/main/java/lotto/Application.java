package lotto;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();

        try {
            // 1. 구입 금액 입력 및 로또 발행
            int purchaseAmount = InputView.inputPurchaseAmount();
            List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);

            System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
            for (Lotto lotto : purchasedLottos) {
                System.out.println(lotto.getNumbers());
            }

            // 2. 당첨 번호 입력
            List<Integer> winningNumbers = InputView.inputWinningNumbers();
            Lotto winningLotto = new Lotto(winningNumbers);

            // 3. 보너스 번호 입력
            int bonusNumber = InputView.inputBonusNumber(winningNumbers);

            // 4. 당첨 결과 계산
            Map<String, Integer> results = lottoService.calculateResults(purchasedLottos, winningLotto, bonusNumber);

            // 5. 당첨 내역 출력
            System.out.println("당첨 통계");
            System.out.println("---");
            results.forEach((key, count) -> {
                System.out.println(key + " - " + count + "개");
            });

            // 6. 수익률 계산 및 출력
            double profitRate = lottoService.calculateProfitRate(results, purchaseAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
