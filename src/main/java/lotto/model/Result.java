package lotto.model;

import java.util.List;

public class Result {

    public static int matchLotto(List<Integer> lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean matchBonus(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            return true;
        }
        return false;
    }
}