package lotto.config;

import lotto.io.InputHandler;
import lotto.io.InputValidator;
import lotto.io.OutputHandler;
import lotto.io.UserLottoParser;
import lotto.io.WinningResultParser;

public class LottoConfig {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoConfig(Config config) {
        this.inputHandler = new InputHandler(
                config.getReader(),
                config.getWriter(),
                new InputValidator()
        );

        this.outputHandler = new OutputHandler(
                config.getWriter(),
                new UserLottoParser(),
                new WinningResultParser()
        );
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
