package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // LottoGame 인스턴스 생성
        LottoGame lottoGame = new LottoGame();

        // 1. 사용자로부터 구입 금액 입력 받기
        InputHandler inputHandler = new InputHandler();
        int purchaseAmount = inputHandler.getPurchaseAmount();
        System.out.println("구입 금액: " + purchaseAmount);

        // 로또 구매
        lottoGame.purchaseLottos(purchaseAmount);

        // 2. 당첨 번호 입력 받기
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        System.out.println("당첨 번호: " + winningNumbers);

        // 3. 보너스 번호 입력 받기
        int bonusNumber = inputHandler.getBonusNumber();
        System.out.println("보너스 번호: " + bonusNumber);

        // 4. 당첨 결과 확인
        lottoGame.checkResults(winningNumbers, bonusNumber);
    }
}