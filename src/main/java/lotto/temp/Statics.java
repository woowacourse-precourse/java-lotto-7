package lotto.temp;

public class Statics {
    public float calculateProfit(int money, int totalPrize){
        float profit = ((float)totalPrize / money) * 100;
        return Math.round(profit * 10) / 10.0f;
    }

}
