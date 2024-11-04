package lotto;

import java.util.List;

public class MatchCounter {

    // 로또 티켓과 당첨 번호 중 일치하는 개수 구하기
    public static int getMatchCount(Lotto lotto, Lotto win) {
        int count = 0;

        for (Integer number : lotto.getNumbers()) {
            if (win.getNumbers().contains(number)) { // 포함되어 있으먄
                count++; // 개수 count
            }
        }
        return count;
    }

    // 로또 티켓 중 보너스 번호 있는 지 체크
    public static boolean checkBonus(Lotto lotto, int bonus) {
        return lotto.getNumbers().contains(bonus);
    }
}
