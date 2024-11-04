package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class LottoConfig {
    private static final LottoRepository lottoRepository = new InMemoryLottoRepository();
    private static final LottoService lottoService = new LottoServiceImpl(getLottoRepository());
    private static final LottoController LOTTO_CONTROLLER = new LottoController(
            getLottoService(), ViewConfig.getInputView(), ViewConfig.getOutputView()
    );

    public static LottoRepository getLottoRepository() {
        return lottoRepository;
    }

    public static LottoService getLottoService() {
        return lottoService;
    }

    public static LottoController getLottoController() {
        return LOTTO_CONTROLLER;
    }
}
