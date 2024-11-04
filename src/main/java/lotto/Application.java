package lotto;

import lotto.basic.NumbersGenerator;
import lotto.basic.StringPrinter;
import lotto.basic.StringReader;
import lotto.exception.ExceptionFormatter;
import lotto.exception.ExceptionLogger;
import lotto.store.LottoStore;
import lotto.store.logger.LottoStoreLogFormatter;
import lotto.store.logger.LottoStoreLoggingAspect;
import lotto.store.lotto.LottoGenerator;
import lotto.ui.LottoResult;
import lotto.ui.UserSettingReader;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = lottoProgram();
        LottoResult result = lottoProgram.start();
        System.out.println(result);
    }

    private static LottoProgram lottoProgram() {
        return new LottoProgramExceptionHandlerAspect(
                new LottoProgram(lottoStore(), userSettingReader()), exceptionLogger()
        );
    }

    private static LottoStore lottoStore() {
        return new LottoStoreLoggingAspect(
                new LottoStore(lottoGenerator()),
                lottoStoreLogFormatter(),
                stringPrinter()
        );
    }

    private static LottoStoreLogFormatter lottoStoreLogFormatter() {
        return new LottoStoreLogFormatter();
    }

    private static LottoGenerator lottoGenerator() {
        return new LottoGenerator(numbersGenerator());
    }

    private static NumbersGenerator numbersGenerator() {
        return new NumbersGenerator();
    }

    private static ExceptionLogger exceptionLogger() {
        return new ExceptionLogger(new ExceptionFormatter(), stringPrinter());
    }

    private static UserSettingReader userSettingReader() {
        return new UserSettingReader(stringReader(), stringPrinter());
    }

    private static StringPrinter stringPrinter() {
        return new StringPrinter();
    }

    private static StringReader stringReader() {
        return new StringReader();
    }
}
