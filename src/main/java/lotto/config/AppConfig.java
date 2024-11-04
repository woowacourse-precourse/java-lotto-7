package lotto.config;

import lotto.LottoDrawResult;
import lotto.LottoPurchaseDetails;
import lotto.controller.LottoController;
import lotto.util.InputHandler;
import lotto.util.InputParser;
import lotto.util.InputValidator;
import lotto.util.LottoNumberGenerator;
import lotto.util.LottoResultAggregator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {
    public InputView provideInputView() {
        return new InputView();
    }

    public InputValidator provideInputValidator() {
        return new InputValidator();
    }

    public LottoController provideLottoController() {
        return new LottoController(provideInputHandler(), provideOutputView(),
                provideLottoPurchaseDetails(), provideLottoNumberGenerator(),
                provideLottoDrawResult(), provideLottoResultAggregator());
    }

    public InputParser provideInputParser() {
        return new InputParser();
    }

    public InputHandler provideInputHandler() {
        return new InputHandler(provideInputValidator(), provideInputParser(), provideInputView());
    }

    public OutputView provideOutputView() {
        return new OutputView();
    }

    public LottoPurchaseDetails provideLottoPurchaseDetails() {
        return new LottoPurchaseDetails();
    }

    public LottoNumberGenerator provideLottoNumberGenerator() {
        return new LottoNumberGenerator();
    }

    public LottoDrawResult provideLottoDrawResult() {
        return new LottoDrawResult();
    }

    public LottoResultAggregator provideLottoResultAggregator() {
        return new LottoResultAggregator();
    }

}
