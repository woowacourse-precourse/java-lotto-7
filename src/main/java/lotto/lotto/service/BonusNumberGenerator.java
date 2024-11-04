package lotto.lotto.service;

import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;

public interface BonusNumberGenerator {
    BonusNumber create(WinningLotto winningLotto);
}
