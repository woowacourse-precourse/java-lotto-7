package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.support.converter.IntegerConverter;
import lotto.support.generator.NumberGenerator;
import lotto.support.generator.RandomIntegerGenerator;
import lotto.support.splitter.Splitter;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {

    public static final String DELIMITER = ",";

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        IntegerConverter converter = new IntegerConverter();
        NumberGenerator<?> generator = new RandomIntegerGenerator();
        Splitter splitter = new Splitter(DELIMITER);

        LottoController lottoController = new LottoController(inputView, outputView, converter, generator, splitter);
        try {
            lottoController.process();
        } finally {
            Console.close();
        }
    }
}
