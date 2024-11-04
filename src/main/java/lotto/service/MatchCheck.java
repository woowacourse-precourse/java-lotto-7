package lotto.service;

import lotto.model.Lotto;
import lotto.view.MatchLotto;

import java.util.HashMap;
import java.util.List;

public class MatchCheck {

    public int matchLotto(List<Integer> paper, List<Integer> winNumber) {
        int check = 0;

        for( Integer Number : paper ){
            if(winNumber.contains(Number) ){ check++; }
        }

        return check;
    }

    public boolean matchBonusNumber(List<Integer> findFivePaper, int bonusNumber){
        for( Integer Number : findFivePaper ){
            if(Number==bonusNumber){ return true; }
        }

        return false;
    }

    public HashMap<Lotto, MatchLotto> winPapers(Lotto[] lotto, List<Integer> winNumber, int bonusNumber) {
        HashMap<Lotto, MatchLotto> winPapers = new HashMap<>();
        boolean bonusMatch = false;
        int matchCount = 0;

        for (Lotto lottoPaper : lotto) {
            matchCount = matchLotto(lottoPaper.getNumbers(), winNumber);
            bonusMatch = false;
            if(matchCount == 5){ bonusMatch = matchBonusNumber(lottoPaper.getNumbers(), bonusNumber); }

            MatchLotto matchLotto = MatchLotto.getRank(matchCount, bonusMatch);

            if (matchLotto != MatchLotto.NO_MATCH) {
                winPapers.put(lottoPaper, matchLotto);
            }
        }

        return winPapers;
    }

}
