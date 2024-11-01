package lotto.util;

import java.util.Map;
import lotto.model.Result;

public class Calculator {
    public static int calculateLottoTicketNumber(int input){
        return input / 1000;
    }

    public static double calculateRateOfReturn(int lottoAmount, Map<Result,Integer> results){
        double totalProfit = 0;
        for(Result result : results.keySet()){
            totalProfit += result.getPrizeMoney() * results.get(result);
        }
        totalProfit /= lottoAmount;
        return Math.round(totalProfit*1000);
    }
}
