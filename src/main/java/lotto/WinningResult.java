package lotto;

/**
 * 전체 당첨 결과를 관리하는 클래스
 */
public class WinningResult {
    private final int[] results;

    public WinningResult() {
        this.results = new int[Prize.values().length];
    }

    /**
     * 특정 등수의 당첨 결과를 추가
     *
     * @param prize 당첨 등수
     */
    public void addResult(Prize prize) {
        if (prize != Prize.NONE) {
            results[prize.ordinal()]++;
        }
    }

    /**
     * @return 총 당첨금
     */
    public long calculateTotalPrize() {
        long totalPrize = 0;
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                totalPrize += (long) results[prize.ordinal()] * prize.getPrize();
            }
        }
        return totalPrize;
    }

    public void printPrizeResults() {
        System.out.printf("3개 일치 (5,000원) - %d개\n", results[Prize.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", results[Prize.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results[Prize.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results[Prize.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results[Prize.FIRST.ordinal()]);
    }
}