package lotto.service.draw;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;

public interface LottoDrawService {

    LottoDrawResult getLottoDrawResult(Lotto drewLotto, int bonusNumber);
}
