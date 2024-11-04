package lotto.service;

import java.util.function.Consumer;
import lotto.view.output.ResultDisplayer;

public class RetryRunner {

    private final ResultDisplayer resultDisplayer;

    public RetryRunner(ResultDisplayer resultDisplayer) {
        this.resultDisplayer = resultDisplayer;
    }

    public void runWithRetry(Runnable runnable) {
        boolean success = false;
        while (!success) {
            try {
                runnable.run();
                success = true;
            } catch (IllegalArgumentException e) {
                resultDisplayer.showErrorMessage(e.getMessage()); // 예외 메시지 출력
            }
        }
    }
}