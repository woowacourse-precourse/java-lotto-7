package lotto.util;

import lotto.view.ErrorOutputView;

import java.util.function.Supplier;

import static lotto.enums.LottoConstant.ACCESS_COUNT;

public class DoLoop {
    public static  <T> T run(Supplier<T> inputFunction) {
        for(int count = 0; count < ACCESS_COUNT.getValue(); count++) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                ErrorOutputView.printErrorMessage(e.getMessage());
            }
        }
        ProgramExit.run(ACCESS_COUNT.getValue());
        return null;
    }
}
