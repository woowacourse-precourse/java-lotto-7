package lotto;


import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.view.ConsoleInputProvider;

public class Application {
    public static void main(String[] args) {
        ConsoleInputProvider inputProvider = new ConsoleInputProvider();
        AppConfig appConfig = new AppConfig();
        LottoController controller = appConfig.createLottoController();
        controller.startLotto();
        inputProvider.closeConsole();

    }
}
