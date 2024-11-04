package lotto.service;

import lotto.domain.lotto.IssuedLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.winning.WinningCombination;

import java.util.ArrayList;
import java.util.List;

public class WinningCheckerService {

    public List<Rank> checkWinning(IssuedLotto issuedLotto, WinningCombination winningCombination) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : issuedLotto.getLottoTickets()) {
            Rank rank = lotto.calculateRank(winningCombination);
            if (rank == Rank.NONE) {
                continue;
            }
            ranks.add(rank);
        }

        return ranks;
    }
}
