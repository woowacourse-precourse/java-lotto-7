package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.LottoVendingMachine;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Config {
    public LottoController lottoController() {
        return new LottoController(lottoVendingMachine(), inputView(), outputView());
    }

    public InputView inputView() {
        return new ConsoleInputView();
    }

    public OutputView outputView() {
        return new ConsoleOutputView();
    }

    public LottoVendingMachine lottoVendingMachine() {
        return new LottoVendingMachine(lottoNumberGenerator());
    }

    public LottoNumberGenerator lottoNumberGenerator() {
        return new RandomLottoNumberGenerator();
    }
}
