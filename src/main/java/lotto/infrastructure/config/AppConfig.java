package lotto.infrastructure.config;

import lotto.adapter.inbound.cli.CliInputAdapter;
import lotto.adapter.outbound.cli.CliOutputAdapter;
import lotto.application.port.inbound.CreateLottoUseCase;
import lotto.application.port.inbound.InputAdapter;
import lotto.application.port.inbound.InputPort;
import lotto.application.port.inbound.ManageLottoUseCase;
import lotto.application.port.outbound.OutputPort;
import lotto.application.service.CliInputPort;
import lotto.application.service.CreateLottoUseCaseImpl;
import lotto.application.service.ManageLottoUseCaseImpl;
import lotto.application.validator.LottoInputValidator;
import lotto.domain.random.RandomUniqueNumbersGenerator;
import lotto.domain.random.RandomGenerator;

public class AppConfig {
    public InputAdapter getCliInputAdapter() {
        return new CliInputAdapter(
                manageLottoUseCase(),
                createLottoUseCase(),
                outputPort(),
                inputPort(),
                lottoInputValidator());
    }

    private ManageLottoUseCase manageLottoUseCase() {
        return new ManageLottoUseCaseImpl();
    }

    private RandomGenerator randomGenerator() {
        return new RandomUniqueNumbersGenerator();
    }

    private CreateLottoUseCase createLottoUseCase() {
        return new CreateLottoUseCaseImpl(randomGenerator());
    }

    private OutputPort outputPort() {
        return new CliOutputAdapter();
    }

    private InputPort inputPort() {
        return new CliInputPort();
    }

    private LottoInputValidator lottoInputValidator() {
        return new LottoInputValidator();
    }
}
