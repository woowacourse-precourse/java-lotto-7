package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.RankingService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        RankingService rankingService = new RankingService();

        LottoController lottoController = new LottoController(lottoService, rankingService);

        lottoController.run();
    }
}
