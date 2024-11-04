package lotto;

import lotto.controller.Controller;
import lotto.model.LottoGenerator;
import lotto.model.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());
        Controller controller = new Controller(inputView, outputView, lottoGenerator);

        controller.run();

    }
}
