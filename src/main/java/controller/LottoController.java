package controller;

import domain.Lotto;
import domain.WinningLotto;
import purchase.PurchaseAmount;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private final PrizeCalculator prizeCalculator = new PrizeCalculator();
    private WinningLotto winningLotto;

    public LottoController(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                generateLottos();
                OutputView.printPurchasedLottos(purchasedLottos);
                winningLotto = InputView.readWinningNumbers();
                calculatePrize();
                OutputView.printPrizeStatistics(prizeCalculator.getPrizeResult(), purchaseAmount.getAmount());
                isRunning = false; // 정상 종료
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
                // 루프를 계속해서 재입력 요구
            }
        }
    }

    private void generateLottos() {
        int count = purchaseAmount.calculateLottoCount();
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(LottoGenerator.generate());
        }
    }

    private void calculatePrize() {
        PrizeResult prizeResult = prizeCalculator.calculate(purchasedLottos, winningLotto);
        // prizeResult는 이미 PrizeCalculator 내에 저장되어 있음
    }
}
