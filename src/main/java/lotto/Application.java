package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchaser lottoPurchaser = Prompt.promptPurchaseAmount();
        List<Lotto> purchasedLottos = lottoPurchaser.purchaseLotto();
        PrintResult.printPurchasedLottos(purchasedLottos);
        Lotto winningLotto = Prompt.promptWinningLotto();
        BonusNumber bonusNumber = Prompt.promptBonusNumber();
        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.checkLottoResult(purchasedLottos, winningLotto, bonusNumber);
        PrintResult.printLottoResultStatistics(lottoResultChecker, purchasedLottos.size());
    }
}
