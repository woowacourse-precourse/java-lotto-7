package lotto.lotto.domain;

import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;

public interface BonusNumberCreatorService {
    BonusNumber create(WinningLotto winningLotto);
}
