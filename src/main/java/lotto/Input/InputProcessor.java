package lotto.Input;

import lotto.Output.OutputView;

public abstract class InputProcessor<T> {
    private final OutputView outputView;

    protected InputProcessor(OutputView outputView) {
        this.outputView = outputView;
    }

    public T process() {
        while (true) {
            try {
                return processInput();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    protected abstract T processInput();
}
