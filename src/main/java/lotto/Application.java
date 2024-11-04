package lotto;

import lotto.controller.LottoController;
import lotto.utility.Splitter.CustomSplitter;
import lotto.utility.converter.Converter;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {

        final String CUSTOM_SPLITTER = ",";

        LottoController lottoController = new LottoController(new ConsoleInputView(), new ConsoleOutputView(),
                new CustomSplitter(CUSTOM_SPLITTER), new Converter());

        lottoController.run();
    }
}
