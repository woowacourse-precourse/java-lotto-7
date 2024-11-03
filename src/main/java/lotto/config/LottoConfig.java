package lotto.config;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
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

        Container.register(WinningNumber.class,
                retryOnFail(() -> new WinningNumber(Input.inputWinningNumber())));

        Container.register(BonusNumber.class,
                retryOnFail(()->
                        new BonusNumber(
                                Input.inputBonusNumber(),
                                Container.getInstance(WinningNumber.class))
                ));

        Container.register(WinningChecker.class,
                retryOnFail(() -> {
                    LottoResult result = Container.getInstance(LottoResult.class);
                    WinningNumber winningNumber = Container.getInstance(WinningNumber.class);
                    BonusNumber bonusNumber = Container.getInstance(BonusNumber.class);

                    return new WinningChecker(
                            winningNumber,
                            bonusNumber,
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