package lotto.service;

import java.util.stream.IntStream;
import lotto.domain.payment.LottoQuantity;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.NumberGenerator;

public class LottoService {
    private final int ZERO = 0;
    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lottos create(LottoQuantity quantity) {
        return Lottos.of(
                IntStream.range(ZERO, quantity.getValue())
                        .mapToObj(i -> Lotto.of(numberGenerator.generate()))
                        .toList()
        );
    }
    
}
