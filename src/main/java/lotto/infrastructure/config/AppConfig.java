package lotto.infrastructure.config;

import lotto.adapters.input.LottoCliInputAdapter;
import lotto.adapters.output.CliOutputAdapter;
import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;

public class AppConfig {

    private final LottoCliInputAdapter lottoCliInputAdapter;
    private final OutputPort outputPort;
    private final InputValidator inputValidator;

    public AppConfig() {
        this.inputValidator = new InputValidator();
        this.outputPort = new CliOutputAdapter();
        this.lottoCliInputAdapter = new LottoCliInputAdapter(inputValidator, outputPort);
    }

    public LottoCliInputAdapter getLottoCliInputAdapter() {
        return lottoCliInputAdapter;
    }
}
