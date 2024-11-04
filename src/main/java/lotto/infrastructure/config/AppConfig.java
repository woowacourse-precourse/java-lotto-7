package lotto.infrastructure.config;

import lotto.adapters.input.cli.LottoCliInputAdapter;
import lotto.adapters.output.cli.CliOutputAdapter;
import lotto.adapters.output.persistence.LottoPersistenceAdapter;
import lotto.application.port.output.OutputPort;
import lotto.application.validation.InputValidator;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.infrastructure.persistence.LottoMemoryRepository;

public class AppConfig {

    private final LottoCliInputAdapter lottoCliInputAdapter;
    private final OutputPort outputPort;
    private final InputValidator inputValidator;
    private final LottoMemoryRepository lottoMemoryRepository;
    private final LottoRepository lottoRepository;

    public AppConfig() {
        this.inputValidator = new InputValidator();
        this.outputPort = new CliOutputAdapter();
        this.lottoCliInputAdapter = new LottoCliInputAdapter(inputValidator, outputPort);
        this.lottoMemoryRepository = new LottoMemoryRepository();
        this.lottoRepository = new LottoPersistenceAdapter(lottoMemoryRepository);
    }

    public LottoCliInputAdapter getLottoCliInputAdapter() {
        return lottoCliInputAdapter;
    }
}
