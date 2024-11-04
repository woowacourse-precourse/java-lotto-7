package lotto;

import lotto.model.LottoManager;
import lotto.model.lotto.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager(
                new InputView(),
                new OutputView(),
                new LottoGenerator()
        );
        lottoManager.run();
    }

}
