package lotto.domain.play;

import lotto.domain.ticket.Lotto;

@FunctionalInterface
public interface LottoGenerator {
    Lotto generate();
}
