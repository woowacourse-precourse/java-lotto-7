package lotto;

public class PrizeResult {

    int totalPrizeMoney = 0;

    public void makeTotalPrizeMoney(){
        for (WinningPrize prize:WinningPrize.values()) {
            totalPrizeMoney += prize.getPrizeMoney();
        }
    }

    public String getRateOfReturn(int money) {
        makeTotalPrizeMoney();
        return makeRateOfReturn((totalPrizeMoney  / (money*1.0))*100);

        //System.out.println(winningCount+"개 일치 " +"(%) - "+totalCount + "개");
    }

    public String makeRateOfReturn(double rateOfMoney) {
        return String.format("%.1f",rateOfMoney);
    }



}
