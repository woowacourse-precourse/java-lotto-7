package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.controller.LottoResultController;
import lotto.dto.LottoDto;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getAppConfig();
        LottoController lottoController = appConfig.lottoController();
        LottoResultController lottoResultController = appConfig.lottoResultController();

        LottoDto dto = lottoController.run();
        lottoResultController.run(dto);
    }
}
