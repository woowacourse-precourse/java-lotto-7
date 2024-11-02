package controller;

import lotto.LottoGenerator;
import lotto.LottoShop;
import lotto.Lottos;
import lotto.PurchaseAmount;
import lotto.RevenueCalculator;
import lotto.WinningLotto;
import view.InputView;
import view.ResultView;

public class LottoController {

    private final InputView input;
    private final ResultView output;

    public LottoController(InputView input, ResultView output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        // 구매 금액 입력
        String answer = input.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(answer);

        // 로또 개수 계산
        LottoShop lottoShop = new LottoShop();
        int purchaseCount = lottoShop.calculatePurchaseCount(purchaseAmount);
        output.showLottoPurchaseCount(purchaseCount);

        // 로또 발행
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.createLottos(purchaseCount);
        output.showCreatedLottos(lottos);

        // 당첨 번호, 보너스 번호 입력
        String winningNumbers = input.inputWinningNumbers();
        String bonusNumber = input.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // 로또와 당첨로또 비교
        lottos.compare(winningLotto);

        // 수익률 계산
        double revenueRate = RevenueCalculator.calculateRevenue(purchaseAmount.getMoney());

        // 당첨 통계
        output.showWinningStatistics(revenueRate);
    }
}
