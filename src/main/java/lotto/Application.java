package lotto;

import lotto.controller.LottoController;
import lotto.model.number_generator.DefaultRandomNumberGenerator;
import lotto.model.shop.LottoShop;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(),
                new OutputView(),
                new DefaultRandomNumberGenerator(),
                new LottoShop()
        );

        lottoController.run();
    }
}
