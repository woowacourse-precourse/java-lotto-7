package lotto.service;

import lotto.domain.Rank;

public class RateService {

    private static int totalMoney = 0;

    public static double calculateRate(RankService ranking, int amount) {
        totalMoney = sumMoney(ranking);
        return totalMoney / (double) amount * 100;
    }

    private static int sumMoney(RankService ranking) {
        for (Rank rank : Rank.values()) {
            totalMoney += rank.getRankMoney() * ranking.rankCount(rank);
        }
        return totalMoney;
    }

}
