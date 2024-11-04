package lotto.utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.config.LottoConfig;
import lotto.viewer.Viewer;

public class RecoveryUtils {

    private static final Viewer VIEWER = LottoConfig.viewer();

    private RecoveryUtils() {
    }

    public static <T, R> R executeWithRetry(Supplier<T> inputSupplier, Function<T, R> processFunction) {
        while (true) {
            try {
                return processFunction.apply(inputSupplier.get());
            } catch (IllegalArgumentException e) {
                VIEWER.printError(e);
            }
        }
    }

    public static <T> void executeWithRetry(Supplier<T> inputSupplier, Consumer<T> processFunction) {
        while (true) {
            try {
                T input = inputSupplier.get();
                processFunction.accept(input);
                return;
            } catch (IllegalArgumentException e) {
                VIEWER.printError(e);
            }
        }
    }
}