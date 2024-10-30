package lotto.config;

import java.util.List;
import lotto.application.Calculator;
import lotto.application.MakeNumbersStrategy;
import lotto.application.Printer;
import lotto.application.Reader;
import lotto.application.calculator.ProfitCalculator;
import lotto.application.numberstrategy.MakeRandomNumbers;
import lotto.application.printer.LottoResultPrinter;
import lotto.application.reader.ConsoleReader;
import lotto.domain.PrizeNumber;
import lotto.domain.prizelotto.FifthPrizeLotto;
import lotto.domain.prizelotto.FirstPrizeLotto;
import lotto.domain.prizelotto.FourthPrizeLotto;
import lotto.domain.prizelotto.PrizeLotto;
import lotto.domain.prizelotto.SecondPrizeLotto;
import lotto.domain.prizelotto.ThirdPrizeLotto;

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

    public PrizeNumber prizeNumber() {
        List<PrizeLotto> prizeLottos = List.of(new FirstPrizeLotto(), new SecondPrizeLotto(), new ThirdPrizeLotto(),
                new FourthPrizeLotto(), new FifthPrizeLotto());
        return new PrizeNumber(prizeLottos);
    }
}
