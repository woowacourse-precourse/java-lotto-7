package lotto;

import lotto.controller.LottoController;
import lotto.strategy.RandomLottoCreateStrategy;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new RandomLottoCreateStrategy());
        lottoController.start();
    }
}
