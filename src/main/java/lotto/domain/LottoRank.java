package lotto.domain;

public enum LottoRank {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000), // 5개 일치 + 보너스
    SIX(6, 2000000000);

    private final int matchCount;
    private final int prize;
    private int count = 0;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }


    public void incrementCount() {
        this.count++;
    }


    public int getCount() {
        return count;
    }


    public int getPrize() {
        return prize;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public static LottoRank valueOfMatch(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return SIX;
        if (matchCount == 5 && matchBonus) return FIVE_BONUS;
        if (matchCount == 5) return FIVE;
        if (matchCount == 4) return FOUR;
        if (matchCount == 3) return THREE;

        return null;
    }

    //통계 출력을 위한 부분
    public String getFormattedOutput(){
        if(this == FIVE_BONUS){
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", matchCount, formatCurrency(prize), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", matchCount, formatCurrency(prize), count);
    }

    //금액에 ,를 붙혀서 나누는 기능
    private String formatCurrency(int amount) {
        return String.format("%,d", amount);
    }

    public static void resetCounts() {
        for (LottoRank rank : LottoRank.values()) {
            rank.count = 0;
        }
    }
}
