package lotto.util;

import java.util.function.Function;
import lotto.ui.error.ErrorView;
import lotto.ui.error.InputError;

public class UIExecutor {

    private final ErrorView errorView;

    public UIExecutor(ErrorView errorView) {
        this.errorView = errorView;
    }

    public <T, R> R execute(Function<T, R> function, T input) {
        while (true) {
            try {
                return function.apply(input);
            } catch (NumberFormatException numberFormatException) {
                errorView.printError(InputError.IS_NOT_NUMBER);
            } catch (IllegalArgumentException illegalArgumentException) {
                errorView.printError(illegalArgumentException.getMessage());
            }
        }
    }
}
