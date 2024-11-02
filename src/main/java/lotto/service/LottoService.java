package lotto.service;

import lotto.domain.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoService {

    public Winning countWinning(LottoTickets lottoTickets, BallNumber ballNumber) {
        Winning winning = new Winning();

        for (Lotto lotto : lottoTickets.getLottos()) {
            int matchCount = countMatchNumbers(lotto.getNumbers(), ballNumber.getWinningNumbers());
            boolean matchBonus = isMatchBonus(lotto.getNumbers(), ballNumber.getBonusNumber());
            Rank rank = calculateRank(matchCount, matchBonus);
            winning.increaseWinningCount(rank);
        }

        return winning;
    }

    private int countMatchNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Set<Integer> matchNumbers = new HashSet<>(lottoNumbers);
        Set<Integer> parsedWinningNumbers = new HashSet<>(winningNumbers);

        matchNumbers.retainAll(parsedWinningNumbers);
        return matchNumbers.size();
    }

    private boolean isMatchBonus(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == bonusNumber);
    }

    private Rank calculateRank(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return Rank.RANK_2;
        }

        List<Rank> rankOrder = List.of(Rank.RANK_LOSE, Rank.RANK_LOSE, Rank.RANK_LOSE,
                Rank.RANK_5, Rank.RANK_4, Rank.RANK_3, Rank.RANK_1);

        return rankOrder.get(matchCount);
    }


}
