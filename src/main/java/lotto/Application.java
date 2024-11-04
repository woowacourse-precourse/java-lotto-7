package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();

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
    }
}
