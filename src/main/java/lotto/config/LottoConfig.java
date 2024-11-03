package lotto.config;

import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;
import lotto.io.Input;

import java.util.function.Supplier;

public class LottoConfig {
    public static void configure() {
        Container.register(LottoGenerator.class,
                retryOnFail(() -> new LottoGenerator(Input.inputPrice())));

        Container.register(LottoResult.class, LottoResult::new);

        Container.register(ProfitCalculator.class, () -> {
            LottoResult result = Container.getInstance(LottoResult.class);
            return new ProfitCalculator(result);
        });

        Container.register(WinningChecker.class,
                retryOnFail(() -> {
                    LottoResult result = Container.getInstance(LottoResult.class);
                    return new WinningChecker(
                            Input.inputWinningNumber(),
                            Input.inputBonusNumber(),
                            result
                    );
                }));
    }

    private static <T> Supplier<T> retryOnFail(Supplier<T> supplier) {
        return () -> {
            while (true) {
                try {
                    return supplier.get();
                } catch (Exception e) {
                    View.showError(e.getMessage());
                }
            }
        };
    }
}