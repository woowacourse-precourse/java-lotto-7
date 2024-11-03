package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;

import java.util.List;

public interface LottoResultCalculator {
    LottoResult calculateResult(final List<Lotto> purchasedLotto, final WinningLotto winningLotto);
}
