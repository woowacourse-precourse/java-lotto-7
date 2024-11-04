package lotto;

/**
 * 당첨 결과를 관리하고 통계를 계산하는 클래스
 */
public class WinningResult {
    private static final int LOTTO_SIZE = 6;
    private final int[] matchCounts = new int[LOTTO_SIZE + 1];
    private int secondPrizeCount = 0;

    /**
     * 한 로또의 당첨 결과를 추가한다.
     */
    public void addResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            secondPrizeCount++;
            return;
        }
        if (matchCount >= 3) {
            matchCounts[matchCount]++;
        }
    }

    /**
     * 당첨 통계를 출력한다.
     */
    public void printStatistics() {
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", secondPrizeCount);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[6]);
    }
    /**
     * 수익률을 계산한다.
     */
    public double calculateProfitRate(int purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (totalPrize * 100.0) / purchaseAmount;
    }

    /**
     * 총 당첨금을 계산한다.
     */
    private long calculateTotalPrize() {
        return matchCounts[3] * 5_000L +
                matchCounts[4] * 50_000L +
                matchCounts[5] * 1_500_000L +
                secondPrizeCount * 30_000_000L +
                matchCounts[6] * 2_000_000_000L;
    }
}