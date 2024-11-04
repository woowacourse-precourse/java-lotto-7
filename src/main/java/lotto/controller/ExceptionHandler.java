package lotto.controller;

import java.util.function.Supplier;
import lotto.ui.OutputView;

public class ExceptionHandler {

    private final OutputView outputView;

    public ExceptionHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.displayException(e.getMessage());
            }
        }
    }

}
