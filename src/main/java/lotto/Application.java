package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 구입 금액 입력
        int amount = InputPrice.getAmount();
        System.out.println("price: "+ amount);

        // 2. 로또 발행
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.buyLottos(amount);
        OutputView.displayLottos(lottos);

        // 3. 당첨 번호 및 보너스 번호 입력
        List<Integer> winningNumbers = InputPrice.getWinningNumbers();
        int bonusNumber = InputPrice.getBonusNumber();

        // 4. 당첨 확인 및 통계
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            Prize prize = lottoMachine.checkPrize(lotto, winningNumbers, bonusNumber);
            lottoResult.recordPrize(prize);
        }
        // 5.결과 출력
        lottoResult.displayResults(amount);
    }
}
