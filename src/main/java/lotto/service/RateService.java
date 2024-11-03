package lotto.service;

import lotto.domain.Rank;

public class RateService {

    private static final int COUNT_ZERO = 0;

    public static double calculateRate(RankService ranking, int amount) {
        int totalMoney = sumMoney(ranking);
        return totalMoney / (double) amount * 100;
    }

    public static int sumMoney(RankService ranking) {
        int totalMoney = COUNT_ZERO;
        for (Rank rank : Rank.values()) {
            totalMoney += rank.getRankMoney() * ranking.rankCount(rank);
        }
        return totalMoney;
    }

}
