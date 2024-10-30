package lotto.domain;

import java.util.List;

public interface LottoFactory {

    Lotto create(int startInclusive, int endInclusive, int count);

}
