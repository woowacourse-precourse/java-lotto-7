package lotto.lotto.config;

import lotto.common.util.random.LottoRandomGenerator;
import lotto.common.util.random.RandomGenerator;
import lotto.lotto.controller.LottoController;
import lotto.lotto.controller.port.LottoService;
import lotto.lotto.infrastructure.LottoRepositoryImpl;
import lotto.lotto.service.LottoFactory;
import lotto.lotto.service.LottoServiceImpl;
import lotto.lotto.service.port.LottoRepository;

public class LottoConfig {

    private static LottoConfig instance;

    private LottoConfig() {
    }

    public static LottoConfig getInstance() {
        if (instance == null) {
            instance = new LottoConfig();
        }
        return instance;
    }

    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository(), lottoFactory());
    }

    private LottoFactory lottoFactory() {
        return new LottoFactory(randomGenerator());
    }

    private RandomGenerator randomGenerator() {
        return new LottoRandomGenerator();
    }

    private LottoRepository lottoRepository() {
        return LottoRepositoryImpl.getInstance();
    }
}
