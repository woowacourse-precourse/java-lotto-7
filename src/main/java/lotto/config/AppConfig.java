package lotto.config;

import lotto.Controller;
import lotto.LottoService;
import lotto.lotto.Cashier;

public class AppConfig {

    private AppConfig() {
        Controller controller = getController();
        controller.start();
    }

    public static void start() {
        new AppConfig();
    }

    private Controller getController() {
        return new Controller(getLottoService());
    }

    private LottoService getLottoService() {
        return new LottoService(getCashier());
    }

    private Cashier getCashier() {
        return new Cashier();
    }
}
