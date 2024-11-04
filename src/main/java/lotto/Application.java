package lotto;

import java.util.List;
import lotto.model.LottoPurchase;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int lottoPurchasePrice = InputView.getValidPurchasePrice();
        int lottoPurchaseQuantity = LottoPurchase.calculateLottoQuantity(lottoPurchasePrice);

        OutputView.printPurchaseInfo(lottoPurchaseQuantity);
        LottoPurchase lottoPurchase = LottoPurchase.of(lottoPurchasePrice);
        OutputView.printLottos(lottoPurchase.getLottos());

        List<Integer> lottoWinningNumbers = InputView.getValidWinningNumbers();
        int bonusNumber = InputView.getValidBonusNumber(lottoWinningNumbers);

        WinningLotto winningLotto = new WinningLotto(lottoWinningNumbers, bonusNumber);
        LottoResult result = LottoResult.of(lottoPurchase.getLottos(), winningLotto);

        OutputView.printResults(result, lottoPurchase.getAmount());
    }


}
