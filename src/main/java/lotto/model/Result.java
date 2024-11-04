package lotto.model;

import java.util.HashMap;

public class Result {
    private final HashMap<Rank, Integer> results;
    private int lottoCount = 0;
    private final int DELIMITER = 5;

    public Result() {
        results = new HashMap<>();
    }

    /**
     * 로또 등수를 현재 통계에 추가
     *
     * @param rank 로또 등수
     */
    public void add(Rank rank) {
        lottoCount++;
        if (Rank.NO_LUCK != rank) {
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    /**
     * 해당 등수인 로또 개수 반환
     *
     * @param rank 로또 등수
     * @return 로또 등수 개수
     */
    public int getCount(Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    /**
     * 전체 통계에서 해당 등수로 얻은 상금 반환
     *
     * @param rank 로또 등수
     * @return 상금
     */
    public long getPrice(Rank rank) {
        return (long) results.getOrDefault(rank, 0) * rank.getPrice();
    }

    /**
     * 수익률 백분율로 계산
     *
     * @return 수익률
     */
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

    /**
     * 소수점 반올림과 소수점 계산
     *
     * @param total 수익률*10,000
     * @return 수익률의 소수 부분
     */
    private int findRightDecimal(long total) {
        int decimal = (int) (total % 100) / 10;
        if (total % 10 >= DELIMITER) {
            decimal++;
        }
        return decimal;
    }

    /**
     * 총 상금 반환 (단위:원)
     *
     * @return 총 상금
     */
    private long getTotalPrice() {
        long result = 0;

        for (Rank rank : results.keySet()) {
            result += getPrice(rank);
        }

        return result;
    }
}
