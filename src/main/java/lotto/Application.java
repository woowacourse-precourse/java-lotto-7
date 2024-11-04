package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.StatisticsView;

public class Application {
    public static void main(String[] args) {
        new LottoController(
                new InputView(),
                new OutputView(),
                new StatisticsView())
                .play();
    }
}
