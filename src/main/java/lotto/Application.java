package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        LotteryStore store = new LotteryStore();
        List<Lotto> purchasedLottos = store.purchase();

        Lotto winningLotto = LottoDraw.inputWinningNumbers();
        int bonusNumber = LottoDraw.inputBonusNumber(winningLotto);

        LottoResult result = new LottoResult();
        result.calculateResults(purchasedLottos, winningLotto, bonusNumber);
        result.displayResults();

    }
}
