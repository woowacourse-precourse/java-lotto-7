package lotto.model;

import lotto.Lotto;
import lotto.prize.Prize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;


public class calculatePrize{
    private final Lotto prize;
    private final int bonus;

    public calculatePrize(Lotto prize, int bonus){
        this.prize = prize;
        this.bonus = bonus;
    }
    public Prize countMatch(Lotto lotto){
        List<Integer> matchNum = new ArrayList<>(lotto.getNumbers());
        List<Integer> prizeNum = new ArrayList<>(prize.getNumbers());
        boolean matchBonus = matchNum.contains(bonus);
        matchNum.retainAll(prizeNum);
        return Prize.calculatePrize(matchNum.size(), matchBonus);
    }
}