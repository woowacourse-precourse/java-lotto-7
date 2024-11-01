package lotto;

import lotto.cotroller.LottoController;
import lotto.domain.User;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
