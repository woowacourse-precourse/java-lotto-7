package lotto.util;

import lotto.view.ErrorOutputView;

import static lotto.view.OutputView.EXIT_APPLICATION;

public class ProgramExit {
    public static void run(int accessCount) {
        ErrorOutputView.printErrorMessage(accessCount + EXIT_APPLICATION.getMessage());
        throw new IllegalStateException();
    }
}
