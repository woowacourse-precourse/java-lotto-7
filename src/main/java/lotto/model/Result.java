package lotto.model;

import java.util.HashMap;

public class Result {
    private final HashMap<Rank, Integer> results;
    private int lottoCount = 0;
    private final int HUNDRED = 100;
    private final int TEN = 10;
    private final long INIT = 0L;
    private final int DELIMITER = 5;

    public Result() {
        results = new HashMap<>();
    }

    public void add(Rank rank) {
        lottoCount++;
        if (Rank.NO_LUCK != rank) {
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    public int getCount(Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    public long getPrice(Rank rank) {
        return (long) results.getOrDefault(rank, 0) * rank.getPrice();
    }

    public String getRate() {
        StringBuilder rate = new StringBuilder();

        long total = getTotalPrice();
        total *= 10;
        total /= lottoCount;

        long naturalNum = total / 100;
        rate.append(naturalNum);

        // 소수점 아래 파트 구하기
        if (total % 100 > 0) {
            rate.append('.');
            int decimal = findRightDecimal(total);
            rate.append(decimal);
        }

        rate.append("%");

        return rate.toString();
    }

    private int findRightDecimal(long total) {
        int decimal = (int) (total % 100) / 10;
        if (total % TEN >= DELIMITER) {
            decimal++;
        }
        return decimal;
    }

    private long getTotalPrice() {
        long result = INIT;

        for (Rank rank : results.keySet()) {
            result += getPrice(rank);
        }

        return result;
    }
}
