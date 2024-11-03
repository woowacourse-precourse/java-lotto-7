package lotto.lotto.infrastructure;

import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.service.NumberGenerator;
import lotto.lotto.service.PurchaseLottoTickets;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AutoRandomNumberLottoTickets implements PurchaseLottoTickets {
    private final NumberGenerator numberGenerator;
    public AutoRandomNumberLottoTickets(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    @Override
    public LottoTickets purchase(int count) {
        return LottoTickets.of(Stream.generate(this::createLotto)
                .limit(count)
                .collect(toList()));
    }
    private Lotto createLotto() {
        return new Lotto(numberGenerator.generate());
    }
}
