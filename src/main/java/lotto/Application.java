package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.NumberGenerator;
import lotto.support.IntegerConverter;
import lotto.support.Splitter;
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
        NumberGenerator<?> generator = new LottoNumberGenerator();
        Splitter splitter = new Splitter(DELIMITER);

        LottoController lottoController = new LottoController(inputView, outputView, converter, generator, splitter);
        try {
            lottoController.process();
        } finally {
            Console.close();
        }
    }
}
