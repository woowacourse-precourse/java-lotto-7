package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        // 1. 사용자로부터 구입 금액 입력 받기
        int purchaseAmount = inputHandler.getPurchaseAmount();
        System.out.println("구입 금액: " + purchaseAmount);

        // 2. 당첨 번호 입력 받기
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();
        System.out.println("당첨 번호: " + winningNumbers);

        // 3. 보너스 번호 입력 받기
        int bonusNumber = inputHandler.getBonusNumber();
        System.out.println("보너스 번호: " + bonusNumber);

        // TODO: 구매한 로또 목록 생성 및 당첨 확인 로직 추가
    }
}