package lotto.service.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningContext;
import lotto.domain.winning.WinningResult;

public interface LottoService {
    boolean validateAmount(int amount);
    WinningResult checkResult(Lotto lotto, WinningContext context);
}
