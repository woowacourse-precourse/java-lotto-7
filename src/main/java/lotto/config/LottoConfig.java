package lotto.config;

import lotto.domain.BonusNumber;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.io.Input;
import lotto.io.View;
import lotto.service.LottoGenerator;
import lotto.service.ProfitCalculator;
import lotto.service.WinningChecker;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class LottoConfig {
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
                retryOnFail(() ->
                        new BonusNumber(
                                Input.inputBonusNumber(),
                                Container.getInstance(WinningNumber.class))
                ));
    }

    /**
     * 특정 작업이 실패할 경우 재시도하는 기능을 제공하는 메서드.
     * 주어진 Supplier가 예외를 발생시킬 경우, 계속해서 재시도한다.
     * 실패 시 사용자가 에러 메시지를 볼 수 있도록 처리하고,
     * 특정 예외(NoSuchElementException) 발생 시에는 그대로 예외를 던진다.
     *
     * @param supplier 실행할 작업을 제공하는 Supplier
     * @param <T> Supplier가 반환하는 객체의 타입
     * @return Supplier가 제공하는 객체
     */
    private static <T> Supplier<T> retryOnFail(Supplier<T> supplier) {
        return () -> {
            while (true) {
                try {
                    return supplier.get();
                } catch (NoSuchElementException e) {
                    throw new NoSuchElementException(e.getMessage());
                } catch (RuntimeException e) {
                    View.showError(e.getMessage());
                }
            }
        };
    }
}