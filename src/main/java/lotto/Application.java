package lotto;

import lotto.common.LottoConfig;

public class Application {

    public static void main(String[] args) {
        LottoConfig lottoConfig = LottoConfig.getInstance();
        LottoApplication lottoApplication = lottoConfig.lottoApplication();
        lottoApplication.execute();
    }
}
