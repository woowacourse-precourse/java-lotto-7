package lotto;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        LottoService lottoService = new LottoService();
        List<Lotto> userLotto = lottoService.generateLotto(purchaseAmount);
        OutputView.printLotto(userLotto);
    }
}
