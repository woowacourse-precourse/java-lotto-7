package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {

    private static LottoController controller = LottoConfig.getLottoController();

    public static void main(String[] args) {
        controller.getLottoAmountInputMessage();
        controller.saveLottoAmountInput();
    }
}
