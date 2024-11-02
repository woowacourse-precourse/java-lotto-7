package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        LottoResult lottoResult = new LottoResult();

        // 1. 로또 구입
        int purchaseAmount = lottoPurchase.getPurchaseAmount();
        List<Lotto> purchasedLottos = lottoPurchase.generateLottoTickets(purchaseAmount / 1000);
        lottoPurchase.printLottoTickets(purchasedLottos);

        // 2. 당첨 번호 입력
        winningNumberInput.inputWinningNumbers();
        winningNumberInput.inputBonusNumber();

        // 3. 로또 결과 확인
        lottoResult.calculateResult(purchasedLottos, winningNumberInput.getWinningNumbers(), winningNumberInput.getBonusNumber());
        lottoResult.printResults();

        // 4. 수익률 계산
        double yield = lottoResult.calculateYield(purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}
