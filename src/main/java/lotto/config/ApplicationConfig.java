package lotto.config;

import lotto.controller.LottoController;
import lotto.factory.LottoMachine;
import lotto.model.LottoBuyer;
import lotto.service.LottoService;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class ApplicationConfig {
    public LottoController createLottoController() {
        return new LottoController(createLottoInputView(), createLottoOutputView(), createLottoService());
    }

    private LottoService createLottoService() {
        return new LottoService(createLottoBuyer(), createLottoMachine());
    }

    private LottoBuyer createLottoBuyer() {
        return new LottoBuyer();
    }

    private LottoInput createLottoInputView() {
        final int retryCount = 5;
        return new LottoInput(retryCount);
    }

    private LottoOutput createLottoOutputView() {
        return new LottoOutput();
    }

    private LottoMachine createLottoMachine() {
        return new LottoMachine();
    }

}
