package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.ProfitCalculator;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        ProfitCalculator profitCalculator = new ProfitCalculator();

        LottoController lottoController = new LottoController(lottoNumberGenerator, profitCalculator);
        lottoController.run();
    }
}
