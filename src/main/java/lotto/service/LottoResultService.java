package lotto.service;

import java.util.List;
import lotto.domain.Guess;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class LottoResultService {

    public List<Rank> determineRanks(Guess guess, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> determineRank(guess, lotto))
                .toList();
    }

    private Rank determineRank(Guess guess, Lotto lotto) {
        int matchCount = (int) lotto.getLotto().stream()
                .filter(guess.getLotto()::contains)
                .count();

        boolean matchBonus = lotto.getLotto().contains(guess.getBonusNumber());

        if (matchCount == 6) {
            return Rank.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return Rank.SECOND;
        }
        if (matchCount == 5) {
            return Rank.THIRD;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }
}

