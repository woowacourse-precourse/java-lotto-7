package lotto.config;

import lotto.ErrorCode;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;
import lotto.io.Input;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class LottoConfig {
    private static final Integer MAX_RETRIES = 100;

    public static void registerCoreServices() {
        Container.register(LottoGenerator.class, retryOnFail(LottoGenerator::new));
        Container.register(LottoResult.class, LottoResult::new);

        Container.register(ProfitCalculator.class, () -> {
            LottoResult result = Container.getInstance(LottoResult.class);
            return new ProfitCalculator(result);
        });

        Container.register(WinningChecker.class, () -> {
                    LottoResult result = Container.getInstance(LottoResult.class);
                    return new WinningChecker(result);
                });
    }

    public static void registerInputDependencies() {
        Container.register(Money.class,
                retryOnFail(() -> new Money(Input.inputPrice())));

        Container.register(WinningNumber.class,
                retryOnFail(() -> new WinningNumber(Input.inputWinningNumber())));

        Container.register(BonusNumber.class,
                retryOnFail(()->
                        new BonusNumber(
                                Input.inputBonusNumber(),
                                Container.getInstance(WinningNumber.class))
                ));
    }

    private static <T> Supplier<T> retryOnFail(Supplier<T> supplier) {
        return () -> {
            int retries = 0;
            while (retries < MAX_RETRIES) {
                try {
                    return supplier.get();
                } catch (Exception e) {
                    View.showError(e.getMessage());
                    retries++;
                }
            }
            throw new NoSuchElementException(ErrorCode.MAX_RETRIES_REACHED.getErrorMessage());
        };
    }
}