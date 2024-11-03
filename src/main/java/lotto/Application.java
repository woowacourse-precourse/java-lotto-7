package lotto;

import lotto.controller.LottoController;
import lotto.domain.Splitter.CustomSplitter;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView(),
                new CustomSplitter(","));

        lottoController.run();
    }
}
