package lotto.ui;

import java.util.function.Supplier;
import lotto.exception.LottoArgumentException;

public class Repeater {
    private final OutputController outputController;
    public Repeater(final OutputController outputController) {
        this.outputController = outputController;
    }


    public <T> T repeat(final Supplier<T> supplier) {
        while (true) {
            try {
                return get(supplier);
            }catch (LottoArgumentException lottoArgumentException) {
                outputController.printErrorMessage(lottoArgumentException);
            }
        }
    }

    private static <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }
}
