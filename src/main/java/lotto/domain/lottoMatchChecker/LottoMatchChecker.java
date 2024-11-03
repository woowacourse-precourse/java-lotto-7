package lotto.domain.lottoMatchChecker;

import java.util.HashMap;
import java.util.List;
import lotto.dto.entity.Lotto;
import lotto.dto.entity.WinningLotto;
import lotto.utils.LottoMatchStatus;

public interface LottoMatchChecker {
    HashMap<LottoMatchStatus, Integer> countMatchingNumbers(WinningLotto winningLotto, List<Lotto> lottos);
}
