package lotto.domain.numberlotto.lottofactory;

import lotto.domain.numberlotto.lotto.NumberLotto;

public interface LottoFactory {

    NumberLotto create(int startInclusive, int endInclusive, int count);

}
