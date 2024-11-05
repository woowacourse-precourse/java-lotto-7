package lotto;

import lotto.config.Config;
import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoConfig lottoConfig = new LottoConfig(new Config());
        LottoService lottoService = new LottoService();

        LottoController controller = new LottoController(
                lottoConfig,
                lottoService
        );

        controller.run();
    }

}
