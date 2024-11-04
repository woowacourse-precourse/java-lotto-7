package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Step 1: 구입 금액 입력 및 로또 티켓 생성
        int purchaseAmount = InputView.requestPurchaseAmount();

        // Step 2: 티켓 개수에 맞게 로또 생성
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos;
        try {
            lottos = lottoGenerator.generateLottos(purchaseAmount);
            OutputView.printPurchaseCount(lottos.size());
            OutputView.printLottoNumbers(lottos);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

        // Step 3: 당첨 번호 입력
        List<Integer> winningNumbers;
        try {
            winningNumbers = InputView.requestWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }

    }
}
