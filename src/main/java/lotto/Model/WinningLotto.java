package lotto.Model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winNumbers;
    private final int bonus;

    public WinningLotto(List<Integer> winNumbers, int bonus){
        this.winNumbers = winNumbers;
        this.bonus = bonus;
    }
    public LottoResult getMatchResult(Lotto lotto){
        int matchCount = countMatchingNumbers(lotto);
        boolean bonusMatched = isBonusMatched(lotto);

        if(matchCount == 6){
            return LottoResult.SIX;
        }
        if(matchCount == 5 && bonusMatched){
            return LottoResult.FIVE_WITH_BONUS;
        }
        if(matchCount == 5){
            return LottoResult.FIVE;
        }
        if(matchCount == 4){
            return LottoResult.FOUR;
        }
        if(matchCount == 3){
            return LottoResult.THREE;
        }
        return null;
    }

    private int countMatchingNumbers(Lotto lotto){
        int count = 0;
        for(int number : lotto.getNumbers()){
            if(winNumbers.contains(number)){
                count++;
            }
        }
        return count;
    }

    private boolean isBonusMatched(Lotto lotto){
        return lotto.getNumbers().contains(bonus);
    }
}

