package lotto.domain.lottofactory;

import lotto.domain.lotto.Lotto;

public interface LottoFactory {

    Lotto create(int startInclusive, int endInclusive, int count);

}
