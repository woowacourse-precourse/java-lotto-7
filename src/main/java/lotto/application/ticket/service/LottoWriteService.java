package lotto.application.ticket.service;

import java.util.stream.IntStream;
import lotto.application.ticket.domain.payment.LottoQuantity;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.domain.ticket.Lottos;

public class LottoWriteService {
    private final int ZERO = 0;
    private final NumberGenerator numberGenerator;

    public LottoWriteService(NumberGenerator numberGenerator) {
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
