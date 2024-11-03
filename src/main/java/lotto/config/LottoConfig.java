package lotto.config;

import lotto.service.LottoGenerator;
import lotto.service.LottoResult;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;
import lotto.io.Input;

public class LottoConfig {
    public static void configure() {
        Container.register(Input.class, Input::new);

        Container.register(LottoGenerator.class, LottoGenerator::new);

        Container.register(LottoResult.class, LottoResult::new);

        Container.register(ProfitCalculator.class, ()-> {
            LottoResult result = Container.getInstance(LottoResult.class);
            return new ProfitCalculator(result);
        });

        Container.register(WinningChecker.class, () -> {
            Input input = Container.getInstance(Input.class);
            LottoResult result = Container.getInstance(LottoResult.class);
            return new WinningChecker(input.getWinningNumber(), input.getBonusNumber(), result);
        });
    }
}