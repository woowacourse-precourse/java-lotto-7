// Application.java (당첨 통계 출력 추가)
package lotto;

import lotto.InputView;
import lotto.ResultView;
import lotto.Lotto;
import lotto.LottoGenerator;
import lotto.LottoResult;
import lotto.Validator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = InputView.readPurchaseAmount();
            int lottoCount = purchaseAmount / 1000;
            List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
            ResultView.printLottos(lottos);

            List<Integer> winningNumbers = InputView.readWinningNumbers();
            int bonusNumber = InputView.readBonusNumber();
            Validator.validateBonusNumberDuplication(bonusNumber, winningNumbers);

            Lotto winningLotto = new Lotto(winningNumbers);
            LottoResult lottoResult = new LottoResult(lottos, winningLotto, bonusNumber);

            ResultView.printStatistics(lottoResult.getResults());

            int totalPrize = lottoResult.getTotalPrize();
            double yield = (double) totalPrize / purchaseAmount * 100;
            yield = Math.round(yield * 100) / 100.0; // 소수점 둘째 자리에서 반올림
            ResultView.printYield(yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}