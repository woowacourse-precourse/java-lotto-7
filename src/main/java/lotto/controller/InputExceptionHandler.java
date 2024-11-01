package lotto.controller;

import lotto.view.OutputView;
import java.util.function.Supplier;

public class InputExceptionHandler {
    private final OutputView outputView;

    public InputExceptionHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T handleInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e.getMessage());
            return handleInput(inputSupplier);
        }
    }
}