package lotto;

import java.util.List;

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
