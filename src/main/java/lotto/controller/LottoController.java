package lotto.controller;


import java.util.function.Supplier;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController() {
        this.lottoService = new LottoService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    private <T> T retryIfErrorOccur(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

