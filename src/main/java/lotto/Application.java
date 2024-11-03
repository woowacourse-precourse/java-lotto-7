package lotto;

import lotto.config.LottoConfig;

public class Application {
    public static void main(String[] args) {
        LottoConfig lottoConfig = new LottoConfig();
        lottoConfig.start();
    }
}
