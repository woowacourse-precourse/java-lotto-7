package lotto;

public class LottoCheck {   // 로또 당첨 및 등수확인
    public int lottoRankResult (int match, int bonus) {     // 1~5등 조건
        if (match == 6) {
            return 1;
        }
        if (match == 5 && bonus == 1) {
            return 2;
        }
        if (match == 4) {
            return 3;
        }
        if (match == 3) {
            return 4;
        }
        if (match == 2) {
            return 5;
        }
        return 0;
    }
}
