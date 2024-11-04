package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.random.CreateRandomNumbers;
import lotto.domain.lotto.random.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        CreateRandomNumbers createRandomNumbers = new LottoNumberGenerator();
        LottoController controller = new LottoController(new InputView(), new OutputView(), createRandomNumbers);
        controller.startLotto();
    }
}
