package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoHandler;
import lotto.model.RankingHandler;

public class Application {
    public static void main(String[] args) {

        final LottoHandler lottoHandler = new LottoHandler();
        final RankingHandler rankingHandler = new RankingHandler();

        final LottoController lottoController = new LottoController(lottoHandler, rankingHandler);

        lottoController.start();
    }
}
