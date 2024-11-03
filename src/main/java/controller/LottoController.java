package controller;

import domain.lotto.Lotto;
import domain.lotto.LottoGenerator;
import domain.lotto.WinningLotto;
import domain.prize.PrizeCalculator;
import domain.prize.PrizeResult;
import purchase.PurchaseAmount;
import view.InputView;
import view.OutputView;

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
                PrizeResult prizeResult = prizeCalculator.calculate(purchasedLottos, winningLotto);
                OutputView.printPrizeStatistics(prizeResult, purchaseAmount.getAmount());
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