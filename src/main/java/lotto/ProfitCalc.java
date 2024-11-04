package lotto;

import static java.lang.Math.round;

public class ProfitCalc {
    float profit=0;
    public float profitCalc(int price, int prize){
        profit=(float)(prize - price)/price * 100;
        return profit;
    }
}
