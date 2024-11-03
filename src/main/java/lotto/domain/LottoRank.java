package lotto.domain;

public enum LottoRank {
    Three_Match(3,"3개 일치 (5,000원) - ", 5_000),
    Four_Match(4,"4개 일치 (50,000원) - ", 50_000),
    Five_Match(5,"5개 일치 (1,500,000원) - ", 1_500_000),
    Five_Bonus_Matches(5,"5개 일치, 보너스 볼 일치 (30,000,000원) - ", 3_000_000),
    All_Matches(6,"6개 일치 (2,000,000,000원) - ", 2_000_000_000);

    private final int matchCount;
    private final String message;
    private final int prize;
    private int count=0;

    LottoRank(int matchCount, String message, int prize) {
        this.matchCount = matchCount;
        this.message = message;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
    public String getMessage() {
        return message;
    }
    public int getPrize() {
        return prize;
    }
    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }
    public static LottoRank searchRank(int matchCount, boolean bonusMatch){
        if(matchCount == 5 && bonusMatch){
            return Five_Bonus_Matches;
        }
        for (LottoRank rank: values()){
            if(rank.getMatchCount() == matchCount){
                return rank;
            }
        }
        return null;
    }

    public static void resetCount(){
        for(LottoRank rank: values()){
            rank.count=0;
        }
    }
}
