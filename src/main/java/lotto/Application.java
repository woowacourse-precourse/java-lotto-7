package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = InputView.getPurchaseAmount();

        PurchaseLotto purchaseLotto = new PurchaseLotto();
        purchaseLotto.salesLotto(purchaseAmount);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        ResultLotto resultLotto = new ResultLotto(purchaseAmount);
        resultLotto.checkResults(purchaseLotto.getLottos(), winningLotto);
        resultLotto.printStatistics();
    }
}