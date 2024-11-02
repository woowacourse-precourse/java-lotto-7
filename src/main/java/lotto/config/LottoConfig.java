package lotto.config;

import lotto.controller.LottoController;
import lotto.repository.LottoPurchaseRepository;
import lotto.repository.LottoRepository;
import lotto.repository.WinningNumberRepository;
import lotto.service.LottoService;

public class LottoConfig {

    private static LottoRepository lottoRepository = new LottoRepository();
    private static LottoPurchaseRepository lottoPurchaseRepository = new LottoPurchaseRepository();
    private static WinningNumberRepository winningNumberRepository = new WinningNumberRepository();

    private static LottoService lottoService = new LottoService(lottoRepository, lottoPurchaseRepository, winningNumberRepository);

    private static LottoController lottoController = new LottoController(lottoService);

    public static LottoController getLottoController() {
        return lottoController;
    }

}
