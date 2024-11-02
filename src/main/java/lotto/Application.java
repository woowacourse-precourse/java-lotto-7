package lotto;

import lotto.config.ApplicationConfig;
import lotto.controller.LottoController;
import lotto.domain.ProfitRate;

public class Application {
    public static void main(String[] args) {
        double profit = 1000.0;
        double amout = 10000.0;
        ProfitRate profitRate = ProfitRate.of(amout, profit);
        System.out.println(profitRate.getProfitRate());
        LottoController lottoController = new ApplicationConfig().lottoController();
        lottoController.run();
    }
}
