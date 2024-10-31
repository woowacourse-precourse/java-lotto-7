package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoController lottoController = new LottoController(lottoNumberGenerator);
        lottoController.run();
    }
}
