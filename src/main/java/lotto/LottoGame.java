package lotto;

import lotto.util.Container;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private static final InputView inputView = Container.getInstance(InputView.class);
    private static final OutputView outputView = Container.getInstance(OutputView.class);

    public static void start() {
        outputView.printStartMessage();
        int amount = inputView.setLottoPrice();
        System.out.println(amount);
    }
}
