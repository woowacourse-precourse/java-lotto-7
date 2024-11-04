package lotto;

import lotto.controller.LottoController;
import lotto.model.number_generator.DefaultRandomNumberGenerator;
import lotto.model.shop.LottoShop;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new ConsoleInputView(),
                new ConsoleOutputView(),
                new DefaultRandomNumberGenerator(),
                new LottoShop()
        );

        lottoController.run();
    }
}
