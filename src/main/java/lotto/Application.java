package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.ApplicationConfiguration;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        LottoController lottoController = applicationConfiguration.lottoController();
        lottoController.lottoProcess();
        Console.close();
    }
}
