import config.AppConfig;
import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        LottoController lottoController = appConfig.lottoController();
        lottoController.run();
    }
}
