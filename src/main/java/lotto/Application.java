package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGame;
import lotto.domain.LottoRepository;

public class Application {
    public static void main(String[] args) {
        LottoRepository lottoRepository = new LottoRepository();
        LottoGame lottoGame = new LottoGame(lottoRepository);
        LottoController lottoController = new LottoController(lottoRepository, lottoGame);
        lottoController.run();

    }
}
