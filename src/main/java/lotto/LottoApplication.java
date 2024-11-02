package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class LottoApplication {

    private static LottoController controller = LottoConfig.getLottoController();

    public static void run() {
        controller.getLottoAmountInputMessage();
        controller.saveLottoAmountInput();
    }

}
