package lotto.config.aop;

import lotto.aop.RetryHandler;
import lotto.config.io.OutputHandlerConfig;

public class RetryHandlerConfig {

    private final RetryHandler retryHandler;

    public RetryHandlerConfig(OutputHandlerConfig outputHandlerConfig) {
        this.retryHandler = new RetryHandler(outputHandlerConfig.getOutputHandler());
    }

    public RetryHandler getRetryHandler() {
        return retryHandler;
    }
}
