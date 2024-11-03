package lotto.statistics;

import lotto.Prize;

import java.util.List;
import java.util.Map;

public class Statistics {
    private static final List<Prize> ALL_PRIZES = List.of(Prize.NOTHING, Prize.FIVE, Prize.FOUR, Prize.THREE, Prize.TWO, Prize.ONE);
    private static final int LOTTO_PRICE = 1000;


    public double rateOfReturn(Map<Prize, Integer> prizes, int count) {
        int allMountMoney = calculateAllMountMoney(prizes, 0);

        double rate = (double) allMountMoney / (double) (count * LOTTO_PRICE) * 100;
        return Math.round(rate * 10) / 10.0;
    }

    private int calculateAllMountMoney(Map<Prize, Integer> prizes, int allMountMoney) {
        for (Prize prize : ALL_PRIZES) {
            allMountMoney += prizes.getOrDefault(prize, 0) * prize.getPrice();
        }
        return allMountMoney;
    }

}
