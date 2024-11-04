package lotto.infrastructure.config;

import lotto.adapters.input.cli.LottoCliInputAdapter;
import lotto.adapters.output.cli.CliOutputAdapter;
import lotto.adapters.output.persistence.LottoPersistenceAdapter;
import lotto.application.port.input.EvaluateWinningLottoUsecase;
import lotto.application.port.input.PurchaseLottoUsecase;
import lotto.application.port.output.OutputPort;
import lotto.application.service.EvaluateWinningLottoCommand;
import lotto.application.service.PurchaseLottoCommand;
import lotto.application.validation.InputValidator;
import lotto.domain.lotto.repository.LottoRepository;
import lotto.domain.lotto.service.LottoMachine;
import lotto.domain.lotto.service.WinningLottoEvaluator;
import lotto.infrastructure.format.LottoFormatter;
import lotto.infrastructure.persistence.LottoMemoryRepository;

public class AppConfig {

    private final LottoCliInputAdapter lottoCliInputAdapter;

    public AppConfig() {
        this.lottoCliInputAdapter = createLottoCliInputAdapter();
    }

    private LottoCliInputAdapter createLottoCliInputAdapter() {
        return new LottoCliInputAdapter(
            createInputValidator(),
            createOutputPort(),
            createPurchaseLottoUsecase(),
            createEvaluateWinningLottoUsecase()
        );
    }

    private InputValidator createInputValidator() {
        return new InputValidator();
    }

    private OutputPort createOutputPort() {
        return new CliOutputAdapter(new LottoFormatter());
    }

    private LottoRepository createLottoRepository() {
        LottoMemoryRepository lottoMemoryRepository = new LottoMemoryRepository();
        return new LottoPersistenceAdapter(lottoMemoryRepository);
    }

    private LottoMachine createLottoMachine() {
        return new LottoMachine();
    }

    private PurchaseLottoUsecase createPurchaseLottoUsecase() {
        return new PurchaseLottoCommand(createLottoRepository(), createLottoMachine());
    }

    private EvaluateWinningLottoUsecase createEvaluateWinningLottoUsecase() {
        return new EvaluateWinningLottoCommand(new WinningLottoEvaluator(), createLottoRepository());
    }

    public LottoCliInputAdapter getLottoCliInputAdapter() {
        return lottoCliInputAdapter;
    }
}
