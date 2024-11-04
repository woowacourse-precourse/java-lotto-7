package lotto.io.printer.lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.io.printer.StringPrinter;

public class ConsoleLottoPrinter implements LottoPrinter {

    private final StringPrinter stringPrinter;

    public ConsoleLottoPrinter(StringPrinter stringPrinter) {
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printLottoList(List<Lotto> lottoList) {
        lottoList.forEach(number -> stringPrinter.printString(number.toString()));
    }

}
