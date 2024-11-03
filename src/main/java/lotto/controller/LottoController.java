package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGenerator;
import lotto.service.ProfitRateCalculator;
import lotto.service.ResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final OutputView outputView = new OutputView();
    private final ResultCalculator resultCalculator = new ResultCalculator();
    private final ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();

    public void run() {
        // 구매할 금액 입력 받기
        PurchasePrice purchasePrice = inputView.receivePurchasePrice();
//        System.out.println("This is the purchase price. " + purchasePrice.getPurchasePrice());

        // 구매 개수만큼 로또 생성
        List<Lotto> generatedLottoNumbers = lottoGenerator.generate(purchasePrice);
//        System.out.println(generatedLottoNumbers);

        outputView.printLottoNumbers(generatedLottoNumbers);

        // 당첨 번호 입력
        WinningNumbers winningNumbers = inputView.receiveWinningNumbers();

        // 보너스 번호 입력
        BonusNumber bonusNumber = inputView.receiveBonusNumber(winningNumbers);

        // 결과 통계
        Map<Ranking, Integer> results = resultCalculator.calculateResult(generatedLottoNumbers, winningNumbers, bonusNumber);
        outputView.printResults(results);

        // 수익률 결과
        double profitRate = profitRateCalculator.calculateProfitRate(purchasePrice, results);
        outputView.printProfitRate(profitRate);
    }
}
