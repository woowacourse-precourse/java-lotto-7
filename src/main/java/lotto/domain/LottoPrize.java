package lotto.domain;

import java.text.NumberFormat;
import java.util.Locale;

public enum LottoPrize {
    NO_PRIZE(0, 0),             // 꽝: 그 외
    FIFTH(3, 5_000),             // 5등: 3개 일치, 5천 원
    FOURTH(4, 50_000),           // 4등: 4개 일치, 5만 원
    THIRD(5, 1_500_000),         // 3등: 5개 일치, 150만 원
    SECOND(5, 30_000_000),       // 2등: 5개 + 보너스 번호 일치, 3천만 원
    FIRST(6, 2_000_000_000);    // 1등: 6개 일치, 20억 원

    private final int matchCount;  // 일치하는 숫자 개수
    private final int prizeMoney;  // 당첨 금액

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getInstance(Locale.KOREA);
        String formattedPrizeMoney = formatter.format(getPrizeMoney());
        if(this == SECOND){
            return getMatchCount() + "개 일치, 보너스 볼 일치 (" + formattedPrizeMoney + "원) - ";
        }
        return getMatchCount() + "개 일치 (" + formattedPrizeMoney + "원) - ";
    }
}
