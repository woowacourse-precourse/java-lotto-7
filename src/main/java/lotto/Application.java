package lotto;

import lotto.application.ScenarioApplication;
import lotto.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ScenarioApplication scenarioApplication = new ScenarioApplication(appConfig);
        scenarioApplication.run();
    }
}
