package lotto;

import java.util.UUID;
import lotto.adapters.input.cli.LottoCliInputAdapter;
import lotto.infrastructure.config.AppConfig;

public class Application {

    public static final UUID userId = UUID.randomUUID();

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        LottoCliInputAdapter lottoCliInputAdapter = appConfig.getLottoCliInputAdapter();
        lottoCliInputAdapter.run();
    }
}
