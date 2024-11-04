package lotto.application.service;

import java.util.EnumMap;
import lotto.application.model.WinningRanking;

public class LottoProfitCalculator {

    public double execute(EnumMap<WinningRanking, Integer> result){
        double rate = 0;
        int count = result.keySet().stream().map(result::get).reduce(0,Integer::sum);

        rate = result.keySet().stream()
                .map(key -> calculateProfit(key, result.get(key)))
                .reduce(0.0, Double::sum);


        return rate / count;
    }

    private double calculateProfit(WinningRanking winningRanking, int count) {

        return winningRanking.getPrizeMoney() * count;

    }


}
