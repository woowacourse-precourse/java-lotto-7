package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. 사용자로부터 구입 금액 입력받기
            int purchaseAmount = InputView.getPurchaseAmount();

            // 2. 로또 번호 생성
            List<Lotto> purchasedLottos = LottoGenerator.generateLottos(purchaseAmount);

            // 3. 생성된 로또 번호 출력
            OutputView.printLottos(purchasedLottos);

            // 4. 당첨 번호 입력받기
            List<Integer> winningNumbers = InputView.getWinningNumbers();
            int bonusNumber = InputView.getBonusNumber();

            // 5. 당첨 결과 계산: 구매 금액(purchaseAmount)을 추가로 전달합니다.
            LottoResult result = LottoChecker.check(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);

            // 6. 당첨 내역 및 수익률 출력
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}