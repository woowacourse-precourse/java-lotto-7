package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 로또 번호 생성기 초기화
        LottoNumGenerator lottoNumGenerator = new LottoNumGenerator();

        // 구매 금액 입력 및 로또 구매
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = InputView.inputPurchaseAmount();
        Buyer buyer = new Buyer(purchaseAmount);
        buyer.purchaseLottos(lottoNumGenerator);

        // 구매한 로또 번호 출력
        buyer.printPurchasedLottos();

        // 당첨 번호 및 보너스 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = InputView.inputWinningNumber();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = InputView.inputBonusNumber();

        // 로또 게임 객체 생성 및 당첨 번호 설정
        LottoGame lottoGame = new LottoGame(winningNumber, bonusNumber);

        // 당첨 결과 출력
        buyer.printResult(lottoGame);
    }
}
