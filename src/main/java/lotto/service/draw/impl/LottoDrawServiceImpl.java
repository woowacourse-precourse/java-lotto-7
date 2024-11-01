package lotto.service.draw.impl;

import lotto.domain.Lotto;
import lotto.domain.LottoDrawResult;
import lotto.service.draw.LottoDrawService;

public class LottoDrawServiceImpl implements LottoDrawService {

    @Override
    public LottoDrawResult getLottoDrawResult(Lotto drewLotto, int bonusNumber) {
        return new LottoDrawResult(drewLotto, bonusNumber);
    }
}
