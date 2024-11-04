package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 구매 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = InputView.inputPurchaseAmount();
        Buyer buyer = new Buyer(purchaseAmount);

        // 당첨/보너스 번호 입력받기
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = InputView.inputWinningNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = InputView.inputBonusNumber();
        LottoGame lottoGame = new LottoGame(winningNumber, bonusNumber);

    }
}
