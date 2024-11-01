package lotto.service;

import lotto.model.Lotto;
import lotto.view.MatchLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchCheck {

    private int matchLotto(List<Integer> paper, List<Integer> winNumber) {
        int check = 0;

        for( Integer Number : paper ){
            if(winNumber.contains(Number) ){ check++; }
        }

        return check;
    }

    private boolean matchBonusNumber(List<Integer> findFivePaper, int bonusNumber){
        for( Integer Number : findFivePaper ){
            if(Number==bonusNumber){ return true; }
        }
        return false;
    }

    public List<Integer> matchCountPapers(Lotto[] lotto, List<Integer> winNumber, int bonusNumber) {
        List<Integer> resultCounts = new ArrayList<>(Collections.nCopies(5, 0));
        int matchCount = 0;
        boolean bonusMatch = false;

        for (Lotto lottoPaper : lotto) {
            matchCount = matchLotto(lottoPaper.getNumbers(), winNumber);
            bonusMatch = matchBonusNumber(lottoPaper.getNumbers(), bonusNumber);

            MatchLotto result = MatchLotto.getResult(matchCount, bonusMatch);

            if (result != null) { resultCounts.set(result.getIndex(), resultCounts.get(result.getIndex()) + 1); }
        }

        return resultCounts;
    }

}
