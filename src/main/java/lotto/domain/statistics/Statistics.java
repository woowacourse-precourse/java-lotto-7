package lotto.domain.statistics;

import java.math.BigInteger;
import lotto.domain.tier.Tier;

public interface Statistics {
    void updateWinningLottoCount();
    BigInteger calculateWinningAmount();
    Long getWinningLottoCount();
    Tier getTier();

}
