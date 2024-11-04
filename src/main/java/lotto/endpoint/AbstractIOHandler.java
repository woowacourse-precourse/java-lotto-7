package lotto.endpoint;

import java.util.function.Function;
import lotto.common.Displayable;
import lotto.endpoint.input.InputView;
import lotto.endpoint.output.OutputView;
import lotto.endpoint.input.InputHandler;

public abstract class AbstractIOHandler implements InputHandler {
    protected final OutputView outputView;
    protected final InputView inputView;

    protected AbstractIOHandler(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    public <T> T handleInput(Displayable message, Function<String, T> parser) {
        while (true) {
            try {
                outputView.printLine(message);
                String input = inputView.input();
                return parser.apply(input);
            } catch (IllegalArgumentException | NullPointerException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
