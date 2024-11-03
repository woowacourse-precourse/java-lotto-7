package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        WinningNumberInput inputHandler = new WinningNumberInput();

        // 사용자에게 구입 금액을 묻고 입력받기
        int purchaseAmount = inputHandler.getPurchaseAmount();

        // 로또 발행 및 발행된 로또 출력
        List<Lotto> purchasedLottos = LottoMachine.issueLottos(purchaseAmount);
        inputHandler.printPurchasedLottos(purchasedLottos);

        // 당첨 번호와 보너스 번호 입력받기
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);

        // 당첨 결과 및 수익률 출력
        LottoChecker checker = new LottoChecker();
        checker.printResults(purchasedLottos, winningNumbers, bonusNumber);
        checker.printProfitRate(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
    }
}
