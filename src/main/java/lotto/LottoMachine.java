package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;
    private final LottoResultChecker resultChecker;
    private final LottoView view;

    public LottoMachine() {
        this.lottoGenerator = new LottoGenerator();
        this.resultChecker = new LottoResultChecker();
        this.view = new LottoView();
    }

    public void run() {
        int purchaseAmount = view.inputPurchaseAmount();
        System.out.println("구매 금액: " + purchaseAmount);

        List<Lotto> purchasedLottos = lottoGenerator.generateLottos(purchaseAmount);
        view.printLottos(purchasedLottos);

        WinningNumber winningNumber = view.inputWinningNumber();
        LottoResult result = resultChecker.checkResults(purchasedLottos, winningNumber);

        view.printResult(result, purchaseAmount);
    }
}
