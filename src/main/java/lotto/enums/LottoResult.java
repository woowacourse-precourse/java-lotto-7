package lotto.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;

/**
 * class: LottoResult.
 *
 * 로또 당첨 결과와 수익률을 관리하는 클래스
 * @author JBumLee
 * @version 2024/11/04
 */
public class LottoResult {
    private static final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private final Map<Prize, Integer> results;
    private double profitRate;

    /**
     * LottoResult 객체를 생성하고 초기화한다.
     * 모든 등수의 당첨 횟수를 0으로 초기화한다.
     */
    public LottoResult() {
        results = new EnumMap<>(Prize.class);
        initializeResults();
    }

    /**
     * 모든 등수의 당첨 횟수를 0으로 초기화한다.
     */
    private void initializeResults() {
        Arrays.stream(Prize.values())
                .forEach(prize -> results.put(prize, 0));
    }

    /**
     * 당첨 결과를 추가한다.
     *
     * @param prize 당첨된 등수
     */
    public void addPrize(Prize prize) {
        results.put(prize, results.get(prize) + 1);
    }

    /**
     * 총 수익률을 계산한다.
     * (당첨금 총액 / 구매금액) * 100
     *
     * @param purchaseAmount 구매 금액
     */
    public void calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        profitRate = (totalPrize * 100.0) / purchaseAmount;
    }

    /**
     * 당첨금 총액을 계산한다.
     *
     * @return 당첨금 총액
     */
    private long calculateTotalPrize() {
        return results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    /**
     * 당첨 통계를 출력한다.
     * 5등부터 1등까지 순서대로 당첨 내역을 출력하고
     * 마지막에 총 수익률을 출력한다.
     */
    public void printStatistics() {
        System.out.println(STATISTICS_HEADER);
        printPrizeStatistics();
        printProfitRate();
    }

    /**
     * 각 등수별 당첨 내역을 출력한다.
     * 5등부터 1등까지 순서대로 출력한다.
     */
    private void printPrizeStatistics() {
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NONE)
                .sorted(Comparator.comparing(Prize::getPrizeMoney))
                .forEach(this::printPrizeCount);
    }

    /**
     * 특정 등수의 당첨 내역을 출력한다.
     *
     * @param prize 출력할 등수
     */
    private void printPrizeCount(Prize prize) {
        System.out.printf("%s - %d개\n",
                prize.getDescription(),
                results.get(prize));
    }

    /**
     * 총 수익률을 출력한다.
     * 소수점 첫째 자리까지 출력한다.
     */
    private void printProfitRate() {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}