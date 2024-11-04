package lotto.config;

import lotto.controller.LottoContoller;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;

public class LottoConfig {
    private static final LottoRepository lottoRepository = new InMemoryLottoRepository();
    private static final LottoService lottoService = new LottoServiceImpl(getLottoRepository());
    private static final LottoContoller lottoContoller = new LottoContoller(
            getLottoService(), ViewConfig.getInputView(), ViewConfig.getOutputView()
    );

    public static LottoRepository getLottoRepository() {
        return lottoRepository;
    }

    public static LottoService getLottoService() {
        return lottoService;
    }

    public static LottoContoller getLottoContoller() {
        return lottoContoller;
    }
}
