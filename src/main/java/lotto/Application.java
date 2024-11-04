package lotto;

import lotto.config.LottoApplicationConfig;
import lotto.controller.LottoApplicationFacade;

public class Application {

    public static void main(String[] args) {
        LottoApplicationConfig lottoApplicationConfig = new LottoApplicationConfig();

        LottoApplicationFacade lottoApplicationFacade = lottoApplicationConfig.getLottoApplicationFacade();
        lottoApplicationFacade.run();
    }
}
