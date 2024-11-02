package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.Map;

public interface LottoResultCalculator {
    Map<WinningResult, Integer> checkLottoResult(final List<Lotto> purchasedLotto, final WinningLotto winningLotto);
}
