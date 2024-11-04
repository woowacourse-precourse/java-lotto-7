package lotto.domain.lottoMatchChecker;

import java.util.HashMap;
import java.util.List;
import lotto.dto.data.Lotto;
import lotto.dto.data.WinningLotto;
import lotto.utils.LottoMatchStatus;

public interface LottoMatchChecker {
    HashMap<LottoMatchStatus, Integer> countMatchingNumbers(WinningLotto winningLotto, List<Lotto> lottos);
}
