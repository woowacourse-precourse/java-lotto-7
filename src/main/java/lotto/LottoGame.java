package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> purchasedLottos;

    public void start() {
        int purchaseAmount = InputView.getPurchaseAmount();
        purchasedLottos = purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottos(purchasedLottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        LottoResult result = LottoResultCalculator.calculate(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(result, purchaseAmount);
    }

    private List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }
}
