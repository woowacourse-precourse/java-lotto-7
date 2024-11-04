package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();
        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);

        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        List<Integer> winningNumbers = WinningNumberInput.requestWinningNumbers();

    }
}
