package lotto;

import static java.lang.Math.round;

public class ProfitCalc {
    float profit=0;
    public float profitCalc(int won){
        LottoChecker lottoChecker = new LottoChecker();
        int prize=lottoChecker.getPrize();
        int price=won;

        profit=(float)(prize - price)/price * 100;

        return profit;
    }
}
