package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoContoller;

public class Application {
    public static void main(String[] args) {
        LottoContoller lottoContoller = LottoConfig.getLottoContoller();
        lottoContoller.run();
    }
}
