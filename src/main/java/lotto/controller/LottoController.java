package lotto.controller;

import static lotto.exception.ErrorType.INVALID_NUMBER_FORMAT;

import java.util.function.Supplier;
import lotto.exception.InvalidNumberFormatException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int lottoCount = getLottoCount();
        outputView.printPurchaseCount(lottoCount);
    }

    private int getLottoCount() {
        return retryUntilValidInput(() -> {
            int amount = parseInt(inputView.getPurchaseAmount());
            return lottoService.getLottoCountByAmount(amount);
        });
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException(INVALID_NUMBER_FORMAT);
        }
    }


    private <T> T retryUntilValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
