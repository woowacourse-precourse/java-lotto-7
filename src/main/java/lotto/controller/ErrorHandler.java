package lotto.controller;

import java.util.function.Consumer;
import lotto.view.OutputView;

public class ErrorHandler implements Consumer<Exception> {

    private final OutputView outputView;

    public ErrorHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    @Override
    public void accept(Exception e) {
        outputView.displayErrorMessage(e);
    }
}
