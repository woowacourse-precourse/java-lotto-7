package lotto.store.logger;

import lotto.basic.StringPrinter;
import lotto.money.Money;
import lotto.store.LottoStore;
import lotto.store.lotto.Lotto;

import java.util.List;

public class LottoStoreLoggingAspect extends LottoStore {
    private final LottoStore main;
    private final LottoStoreLogFormatter formatter;
    private final StringPrinter printer;

    public LottoStoreLoggingAspect(
            LottoStore lottoStore,
            LottoStoreLogFormatter lottoStoreLogFormatter,
            StringPrinter stringPrinter) {
        super(null);
        main = lottoStore;
        formatter = lottoStoreLogFormatter;
        printer = stringPrinter;
    }

    @Override
    public List<Lotto> sale(Money money) {
        List<Lotto> result = main.sale(money);
        printer.print(formatter.format(result));
        return result;
    }
}
