package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.FortuneMachine;
import lotto.service.FortuneMachineService;
import lotto.service.InputService;
import lotto.service.LottoService;
import lotto.service.OutputService;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class AppConfig {

    public InputView getInputView() {
        return new InputViewImpl();
    }

    public OutputView getOutputView() {
        return new OutputViewImpl();
    }

    public InputService getInputService() {
        return new InputService(getInputView());
    }

    public OutputService getOutputService() {
        return new OutputService(getOutputView());
    }

    public FortuneMachine getFortuneMachine() {
        return new FortuneMachine();
    }

    public LottoService getLottoService() {
        return new LottoService(getInputView(), getOutputView());
    }

    public FortuneMachineService getFortuneMachineService() {
        return new FortuneMachineService(getFortuneMachine());
    }

    public LottoController getLottoController() {
        return new LottoController(getLottoService(), getInputService(), getOutputService(), getFortuneMachineService());
    }



}
