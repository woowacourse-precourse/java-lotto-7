package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoController lottoController = new LottoController(lottoNumberGenerator);
        lottoController.run();
    }
}
