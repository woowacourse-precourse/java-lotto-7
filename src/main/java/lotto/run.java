package lotto;

import lotto.Lotto;
import lotto.core.LottoGenerator;
import lotto.core.LottoMatcher;
import lotto.core.LottoResult;
import lotto.core.LottoStatistics;
import lotto.inputview.BonusNumberInputView;
import lotto.inputview.LottoNumbersInputView;
import lotto.inputview.PurchaseAmountInputView;
import lotto.outputview.LottoNumbersOutputView;
import lotto.outputview.LottoStatisticsOutputView;

import java.util.ArrayList;
import java.util.List;

public class run {
    public static void run() {
        // 1. 구매 금액 입력 및 로또 개수 계산
        int numberOfLottos = PurchaseAmountInputView.inputPurchaseAmount();

        // 2. 로또 번호 생성
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lottoNumbers = LottoGenerator.generate();
            purchasedLottos.add(new Lotto(lottoNumbers));
        }

        // 3. 로또 번호 출력
        LottoNumbersOutputView.printPurchasedLottos(numberOfLottos, purchasedLottos);

        // 4. 당첨 번호 입력
        Lotto winningLotto = LottoNumbersInputView.inputLottoNumbers();
        int bonusNumber = BonusNumberInputView.inputBonusNumber();

        // 5. 당첨 통계 계산 및 출력
        List<LottoResult> results = new ArrayList<>();
        LottoMatcher lottoMatcher = new LottoMatcher(winningLotto.getNumbers(), bonusNumber);
        for (Lotto lotto : purchasedLottos) {
            LottoResult result = lottoMatcher.match(lotto.getNumbers());
            results.add(result);
        }

        // 6. 통계 출력
        LottoStatisticsOutputView.printStatistics(results);

        // 7. 수익률 계산
        LottoStatistics lottoStatistics = new LottoStatistics(results, numberOfLottos * 1000);
        double profitRate = lottoStatistics.calculateProfitRate();

        // 8. 수익률을 소수점 첫째 자리에서 반올림하여 출력
        double roundedProfitRate = Math.round(profitRate * 10.0) / 10.0; // 첫째 자리에서 반올림
        System.out.printf("총 수익률은 %.1f%%입니다.%n", roundedProfitRate); // 출력 형식 수정
    }
}
