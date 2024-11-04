package lotto.controller;

import java.util.function.Supplier;
import lotto.converter.Converter;
import lotto.view.OutputView;

public class IteratorInputTemplate {

    private final OutputView outputView;

    public IteratorInputTemplate(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T execute(Supplier<String> inputSupplier, Converter<String, T> converter) {
        while (true) {
            try {
                String input = inputSupplier.get();
                return converter.convert(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
