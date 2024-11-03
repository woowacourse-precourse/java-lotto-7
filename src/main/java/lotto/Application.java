package lotto;

import lotto.controller.LottoController;
import lotto.config.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoConfig config = LottoConfig.getInstance();
        LottoController controller = LottoController.getInstance(config);
        controller.run();
    }
}
