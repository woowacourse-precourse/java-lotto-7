package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoController controller = new LottoController(lottoGenerator, calculator);

        controller.run();
    }
}
