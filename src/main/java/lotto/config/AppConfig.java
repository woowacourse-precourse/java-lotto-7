package lotto.config;

import lotto.controller.LottoController;
import lotto.controller.LottoGameController;
import lotto.controller.LottoStatisticController;
import lotto.controller.WinningNumbersController;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.LottoStatisticService;
import lotto.service.LottoStatisticServiceImpl;

public class AppConfig {
    public LottoGameController lottoGameController() {
        return new LottoGameController(lottoController(), lottoStatisticController(), new WinningNumbersController());
    }


    private LottoController lottoController() {
        return new LottoController(lottoService());
    }

    private LottoStatisticController lottoStatisticController() {
        return new LottoStatisticController(lottoStatisticService());
    }

    private LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }

    private LottoStatisticService lottoStatisticService() {
        return new LottoStatisticServiceImpl(lottoRepository());
    }

    private LottoRepository lottoRepository() {
        return InMemoryLottoRepository.getInstance();
    }
}
