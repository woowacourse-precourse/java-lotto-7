package lotto;

import lotto.controller.LottoController;
import lotto.domain.utility.Splitter.CustomSplitter;
import lotto.domain.utility.converter.Converter;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView(),
                new CustomSplitter(","), new Converter());

        lottoController.run();
    }
}
