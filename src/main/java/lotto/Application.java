package lotto;

import lotto.domain.RandomLottoStrategy;
import lotto.presentation.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new RandomLottoStrategy());
        lottoController.run();
    }
}
