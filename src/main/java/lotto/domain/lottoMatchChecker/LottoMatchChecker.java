package lotto.domain.lottoMatchChecker;

import java.util.HashMap;
import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;
import lotto.utils.LottoMatchStatus;

public interface LottoMatchChecker {
    HashMap<LottoMatchStatus, Integer> countMatchingNumbers(WinningLotto winningLotto, List<Lotto> lottos);
}
