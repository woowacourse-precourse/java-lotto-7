package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserLotto userLotto;

    public void run() {
        int price = inputView.printGetPurchasePrice();
        userLotto = new UserLotto(price);
        outputView.printLottoCount(price);

        outputView.printUserLottoNumbers(userLotto.generateLotto());
    }
}
