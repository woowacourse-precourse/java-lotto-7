package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;

public class LottoConfig {

    private static LottoRepository lottoRepository = new LottoRepository();
    private static LottoPurchaseRepository lottoPurchaseRepository = new LottoPurchaseRepository();

    private static LottoService lottoService = new LottoService(lottoRepository, lottoPurchaseRepository);

    private static LottoController lottoController = new LottoController(lottoService);

    public static LottoController getLottoController() {
        return lottoController;
    }

}
