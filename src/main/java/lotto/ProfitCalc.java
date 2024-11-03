package lotto;

import static java.lang.Math.round;

public class ProfitCalc {
    float profit=0;
    public float profitCalc(int won){
        //수익률 = (총 당첨금액 - 지불금액)/지불금액 x100
        int prize=0;
        int price=won;

        profit=(float)(prize - price)/price * 100;

        return profit;
    }
}
