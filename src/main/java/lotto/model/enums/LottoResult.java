package lotto.model.enums;

import static lotto.utils.Constants.*;
import static lotto.utils.LottoConstants.*;


public enum LottoResult {


    FIFTH("3개 일치 (5,000원) - %d개", FIFTH_PRIZE_MONEY, 0, FIFTH_PRIZE_MATCH_COUNT, false),

    FOURTH("4개 일치 (50,000원) - %d개", FOURTH_PRIZE_MONEY, 0, FOURTH_PRIZE_MATCH_COUNT, false),

    THIRD("5개 일치 (1,500,000원) - %d개", THIRD_PRIZE_MONEY, 0, THIRD_PRIZE_MATCH_COUNT, false),

    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", SECOND_PRIZE_MONEY, 0, SECOND_PRIZE_MATCH_COUNT, true),
    FIRST("6개 일치 (2,000,000,000원) - %d개", FIRST_PRIZE_MONEY, 0, FIRST_PRIZE_MATCH_COUNT, false);


    private final String message;
    private final Integer prizeMoney;
    private final Integer matchCount;
    private final Boolean bonusMatch;
    private Integer count;


    LottoResult(String message, Integer prizeMoney, Integer count, Integer matchCount, Boolean bonusMatch) {
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.count = count;
    }

    public static void initializeCount() {
        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResult.count = INITIALIZE_VALUE;
        }
    }

    public static void updatePrizeCount(int countMatchingNumbers, boolean checkSecondPrizeMatch) {
        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.matchCount == countMatchingNumbers
                    && lottoResult.bonusMatch == checkSecondPrizeMatch) {
                lottoResult.count++;
            }
        }
    }


    public static Integer getTotalPrize() {
        int totalPrize = INITIALIZE_VALUE;
        for (LottoResult lottoResult : LottoResult.values()) {
            totalPrize += lottoResult.prizeMoney * lottoResult.count;
        }
        return totalPrize;
    }

    public Integer getCount() {
        return count;
    }

    public String getMessage() {
        return message;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

}
