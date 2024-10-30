package lotto.config;

import java.util.List;
import lotto.application.Calculator;
import lotto.application.LottoApplication;
import lotto.application.MakeNumbersStrategy;
import lotto.application.Printer;
import lotto.application.Reader;
import lotto.calculator.ProfitCalculator;
import lotto.domain.PrizeNumber;
import lotto.numberstrategy.MakeRandomNumbers;
import lotto.printer.LottoResultPrinter;
import lotto.prizelotto.FifthPrizeLotto;
import lotto.prizelotto.FirstPrizeLotto;
import lotto.prizelotto.FourthPrizeLotto;
import lotto.prizelotto.PrizeLotto;
import lotto.prizelotto.SecondPrizeLotto;
import lotto.prizelotto.ThirdPrizeLotto;
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

    public PrizeNumber prizeNumber() {
        List<PrizeLotto> prizeLottos = List.of(new FirstPrizeLotto(), new SecondPrizeLotto(), new ThirdPrizeLotto(),
                new FourthPrizeLotto(),
                new FifthPrizeLotto());
        return new PrizeNumber(prizeLottos);
    }

    public LottoApplication lottoApplication() {
        return new LottoApplication(makeNumbersStrategy(), reader(), printer());
    }
}
