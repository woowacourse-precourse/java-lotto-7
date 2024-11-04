package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.enums.Rank;

public class WinningResultService {

    public WinningResult determineWinningRanks(LottoTickets lottoTickets, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        // 각 티켓을 순회하며 당첨 등수를 계산
        lottoTickets.getLottoTickets().forEach(lotto -> {
            int matchCount = winningLotto.getMatchCount(lotto);
            boolean hasBonus = winningLotto.hasBonusNumber(lotto);
            Rank rank = Rank.valueOf(matchCount, hasBonus);
            winningResult.updateResult(rank);
        });

        return winningResult;
    }
}
