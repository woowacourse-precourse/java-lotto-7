package lotto.model;

import java.util.List;

public class LottoGame {

    public static int matchNum(List<Integer> lotto, List<Integer> lastWeekLotto) {
        return (int) lotto.stream().filter(lastWeekLotto::contains).count();
    }

    public static int matchBonus(List<Integer> Lotto, int bonusBall) {
        if (Lotto.contains(bonusBall)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Rank getRank(List<Integer> lotto, List<Integer> lastWeekLotto, int bonusBall) {
        int matchNum = matchNum(lotto, lastWeekLotto);
        int matchBonus = matchBonus(lotto, bonusBall);
        return Rank.valueOf(matchNum, matchBonus == 1);
    }
}

