package lotto.application;

import lotto.ConsoleReader;
import lotto.MakeNumbersStrategy;
import lotto.Reader;
import lotto.numberstrategy.MakeRandomNumbers;

public class AppConfig {

    public Reader reader() {
        return new ConsoleReader();
    }

    public MakeNumbersStrategy makeNumbersStrategy() {
        return new MakeRandomNumbers();
    }

}
