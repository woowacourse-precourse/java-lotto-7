package lotto.config;

import lotto.application.Calculator;
import lotto.application.MakeNumbersStrategy;
import lotto.application.Printer;
import lotto.application.Reader;
import lotto.calculator.ProfitCalculator;
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
        return new ProfitCalculator();
    }

    public Printer printer() {
        return new LottoResultPrinter();
    }
}
