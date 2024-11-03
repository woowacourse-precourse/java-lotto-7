package lotto.adapters.input;

import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;

public class LottoCliInputAdapter {

    private final InputValidator inputValidator;
    private final OutputPort outputPort;

    public LottoCliInputAdapter(InputValidator inputValidator, OutputPort outputPort) {
        this.inputValidator = inputValidator;
        this.outputPort = outputPort;
    }

    public void run() {

    }
}
