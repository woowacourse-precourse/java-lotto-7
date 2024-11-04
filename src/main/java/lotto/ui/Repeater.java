package lotto.ui;

import java.util.function.Supplier;
import lotto.exception.LottoArgumentException;

public class Repeater {
    private final OutputController outputController;

    public Repeater(final OutputController outputController) {
        this.outputController = outputController;
    }

    public <T> T repeatWithErrorMessage(final Supplier<T> supplier) {
        while (true) {
            try {
                return getObject(supplier);
            } catch (LottoArgumentException lottoArgumentException) {
                outputController.printErrorMessage(lottoArgumentException);
            }
        }
    }

    private static <T> T getObject(final Supplier<T> supplier) {
        return supplier.get();
    }
}
