package lotto.domain.numberlotto.lottofactory;

import lotto.domain.numberlotto.lotto.Lotto;

public interface LottoFactory {

    Lotto create(int startInclusive, int endInclusive, int count);

}
