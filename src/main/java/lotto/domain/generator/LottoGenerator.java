package lotto.domain.generator;

import lotto.domain.number.Lotto;

@FunctionalInterface
public interface LottoGenerator {

    Lotto generate(final int min, final int max, final int count);
}
