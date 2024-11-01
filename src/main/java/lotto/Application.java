package lotto;

import lotto.controller.LottoController;
import lotto.generator.LottoGenerator;
import lotto.validator.LottoBonusNumberValidator;
import lotto.validator.LottoNumberValidator;
import lotto.validator.LottoWinningNumbersValidator;
import lotto.view.LottoInputValidator;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator(1, 45);
        LottoController controller = new LottoController(new LottoView(new LottoInputValidator()),
                new LottoGenerator(1_000, 1, 45, 6),
                new LottoWinningNumbersValidator(lottoNumberValidator),
                new LottoBonusNumberValidator(lottoNumberValidator));
        controller.run();
    }
}
