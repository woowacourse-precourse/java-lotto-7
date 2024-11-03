package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;
import lotto.service.LottoService;

public class LottoConfig {

    private static final LottoRepository lottoRepository = new LottoRepository();
    private static final LottoPurchaseRepository lottoPurchaseRepository = new LottoPurchaseRepository();
    private static final WinningNumberRepository winningNumberRepository = new WinningNumberRepository();

    private static final LottoService lottoService = new LottoService(lottoRepository, lottoPurchaseRepository, winningNumberRepository);

    private static final LottoController lottoController = new LottoController(lottoService);

    public static LottoController getLottoController() {
        return lottoController;
    }

}
