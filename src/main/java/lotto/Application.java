package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager(
                new InputView(),
                new OutputView()
        );
        lottoManager.run();
    }
}
