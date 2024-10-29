package lotto.config;

import lotto.reader.ConsoleReader;
import lotto.application.MakeNumbersStrategy;
import lotto.application.Reader;
import lotto.numberstrategy.MakeRandomNumbers;

public class AppConfig {

    public Reader reader() {
        return new ConsoleReader();
    }

    public MakeNumbersStrategy makeNumbersStrategy() {
        return new MakeRandomNumbers();
    }

}
