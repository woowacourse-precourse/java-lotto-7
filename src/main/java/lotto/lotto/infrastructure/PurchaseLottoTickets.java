package lotto.lotto.infrastructure;

import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.LottoTicketsCreatorService;
import lotto.lotto.domain.NumberGenerator;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoTicketsCreator implements LottoTicketsCreatorService {
    private final NumberGenerator numberGenerator;
    public LottoTicketsCreator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    @Override
    public LottoTickets purchaseLottoTickets(int count) {
        return LottoTickets.of(Stream.generate(this::createLotto)
                .limit(count)
                .collect(toList()));
    }
    private Lotto createLotto() {
        return new Lotto(numberGenerator.generate());
    }
}
