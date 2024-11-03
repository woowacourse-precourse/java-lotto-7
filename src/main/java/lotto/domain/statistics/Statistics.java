package lotto.domain.statistics;

import java.math.BigInteger;

public interface Statistics {
    Statistics updateWinningLottoCount(Long winningLottoCount);
    BigInteger calculateWinningAmount();
    Long getWinningLottoCount();

}
