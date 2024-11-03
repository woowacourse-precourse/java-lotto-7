package lotto;

import lotto.exception.ExceptionLogger;
import lotto.money.Money;
import lotto.ui.LottoResult;
import lotto.ui.WinningNumberSettings;

public class LottoProgramExceptionHandlerAspect extends LottoProgram {
    private final LottoProgram main;
    private final ExceptionLogger logger;

    public LottoProgramExceptionHandlerAspect(LottoProgram lottoProgram, ExceptionLogger exceptionLogger) {
        super(null, null);
        main = lottoProgram;
        logger = exceptionLogger;
    }

    @Override
    public LottoResult start() {
        try {
            return main.start();
        } catch (RuntimeException exception) {
            logger.log(exception);
        }
        return null;
    }
}
