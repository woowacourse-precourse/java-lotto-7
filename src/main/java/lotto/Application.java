package lotto;

import lotto.input.LottoInput;
import lotto.purchase.LottoPurchase;
import lotto.result.LottoResult;
import lotto.service.ProfitCalculator;
import lotto.util.PurchaseValidator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoInput lottoInput = new LottoInput();
        int cost = lottoInput.readCost();
        List<Integer> winningNumbers = lottoInput.readWinningNumbers();
        int bonusNumber = lottoInput.readBonus();

        PurchaseValidator.validatePurchaseAmount(cost);
        int purchaseAmount = cost/1000;

        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
        //구매 내역 출력
        lottoPurchase.printLottos();

        LottoResult lottoResult = new LottoResult(lottoPurchase, winningNumbers, bonusNumber);
        //당첨내역 출력
        lottoResult.printResults();

        //수익률 출력
        ProfitCalculator profitCalculator = new ProfitCalculator();
        profitCalculator.printProfitRate(cost, lottoResult.getTotalPrize());
    }
}
