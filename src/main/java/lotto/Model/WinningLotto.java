package lotto.Model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winNumbers;
    private final int bonus;

    public WinningLotto(List<Integer> winNumbers, int bonus){
        this.winNumbers = winNumbers;
        this.bonus = bonus;
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

