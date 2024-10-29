package lotto.model.enums;

public enum LottoResult {

    FIRST("6개 일치 (2,000,000,000원) - %d개", 2_000_000_000, 0, 6, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000, 0, 5,true),
    THIRD("5개 일치 (1,500,000원) - %d개", 1_500_000, 0, 5,false),
    FOURTH("4개 일치 (50,000원) - %d개", 50_000, 0,4,false),
    FIFTH("3개 일치 (5,000원) - %d개", 5_000, 0,3,false);


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

    public static void initializeCount(){
        for (LottoResult lottoResult : LottoResult.values()){
            lottoResult.count = 0;
        }
    }

    public static void updatePrizeCount(int countMatchingNumbers, boolean checkSecondPrizeMatch){
        for (LottoResult lottoResult : LottoResult.values()){
            if (lottoResult.matchCount == countMatchingNumbers
                    && lottoResult.bonusMatch == checkSecondPrizeMatch){
                lottoResult.count++;
            }
        }
    }


    public static Integer getTotalPrize(){
        int totalPrize = 0;
        for (LottoResult lottoResult : LottoResult.values()){
            totalPrize += lottoResult.prizeMoney * lottoResult.count;
        }
        return totalPrize;
    }

    public Integer getCount(){
        return count;
    }

    public String getMessage(){
        return message;
    }

    public Integer getPrizeMoney(){
        return prizeMoney;
    }

}
