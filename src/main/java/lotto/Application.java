package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.utils.LottoNumberGenerator;
import lotto.utils.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new RandomNumberGenerator();
        GameController gameController = new GameController(new GameService(lottoNumberGenerator));
        gameController.lottoGameStart();
    }
}
