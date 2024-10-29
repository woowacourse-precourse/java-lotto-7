package lotto.config;

import lotto.application.Calculator;
import lotto.application.MakeNumbersStrategy;
import lotto.application.Printer;
import lotto.application.Reader;
import lotto.calculator.PrizeCalculator;
import lotto.numberstrategy.MakeRandomNumbers;
import lotto.printer.LottoResultPrinter;
import lotto.reader.ConsoleReader;

public class AppConfig {

    public Reader reader() {
        return new ConsoleReader();
    }

    public MakeNumbersStrategy makeNumbersStrategy() {
        return new MakeRandomNumbers();
    }

    public Calculator calculator() {
        return new PrizeCalculator();
    }

    public Printer printer() {
        return new LottoResultPrinter();
    }
}
