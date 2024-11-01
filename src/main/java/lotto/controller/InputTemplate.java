package lotto.controller;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.OutputView;

public class InputTemplate {

    private final OutputView outputView;

    public InputTemplate(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T execute(Supplier<String> inputSupplier, Function<String, T> converter) {
        while (true) {
            try {
                String input = inputSupplier.get();
                return converter.apply(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
