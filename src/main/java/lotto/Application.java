package lotto;

import lotto.controller.LottoController;
import lotto.domain.DefaultLottoGenerator;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResultCalculator;

public class Application {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new DefaultLottoGenerator();
        LottoResultCalculator calculator = new LottoResultCalculator();

        LottoController controller = new LottoController(lottoGenerator, calculator);

        controller.run();
    }
}
