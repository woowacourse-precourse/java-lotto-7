package lotto.model;


import java.text.DecimalFormat;

public class WinningStatistic {

    private final int matchCount;
    private final int prizeAmount;
    private int occurrence;

    public WinningStatistic(int matchCount, int prizeAmount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.occurrence = 0; // 초기화 시 0으로 설정
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void incrementOccurrence() {
        this.occurrence++;
    }

    public int calculateEarnings() {
        return occurrence * prizeAmount;
    }

    public String presentStatus(){
        String status = "";
        status += matchCount + "개 일치";
        if(prizeAmount == 30000000){
            status +=", 보너스 볼 일치";
        }
        return status;
    }
}
