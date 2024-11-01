package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoRandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator generator = new LottoRandomGenerator();

        LottoController controller = new LottoController(inputView, outputView, generator);

        controller.play();
    }
}
