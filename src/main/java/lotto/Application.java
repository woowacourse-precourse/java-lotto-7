package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.requestPurchaseAmount();

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos;
        try {
            lottos = lottoGenerator.generateLottos(purchaseAmount);
            // 로또 번호 출력 등 추가 로직
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return;
        }
    }
}
