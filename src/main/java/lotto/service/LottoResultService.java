package lotto.service;

import java.util.List;
import lotto.domain.Guess;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class LottoResultService {

    public List<Rank> determineRanks(Guess guess, List<Lotto> lottos){
        return lottos.stream()
                .map(lotto -> determineRank(guess,lotto))
                .toList();
    }

    private Rank determineRank(Guess guess, Lotto lotto) {
        int matchCount = (int) lotto.getLotto().stream()
                .filter(guess.getLotto()::contains)
                .count();

        boolean matchBonus = lotto.getLotto().contains(guess.getBonusNumber());

        return Rank.findRank(matchCount,matchBonus);
    }
}
