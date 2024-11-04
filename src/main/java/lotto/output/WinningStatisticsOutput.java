package lotto.output;

import lotto.dto.WinningResultDTO;

public class WinningStatisticsOutput {

    private static final int CORRECT_3_PRICE = 5000;
    private static final int CORRECT_4_PRICE = 50000;
    private static final int CORRECT_5_PRICE = 1500000;
    private static final int CORRECT_5_WITH_BONUS_PRICE = 30000000;
    private static final int CORRECT_6_PRICE = 2000000000;

    public void run(WinningResultDTO winningResultDTO, int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%d원) - %d개\n", CORRECT_3_PRICE, winningResultDTO.getCorrect3());
        System.out.printf("4개 일치 (%d원) - %d개\n", CORRECT_4_PRICE, winningResultDTO.getCorrect4());
        System.out.printf("5개 일치 (%d원) - %d개\n", CORRECT_5_PRICE, winningResultDTO.getCorrect5());
        System.out.printf("5개 일치, 보너스 볼 일치 (%d원) - %d개\n", CORRECT_5_WITH_BONUS_PRICE, winningResultDTO.getCorrect5withBonus());
        System.out.printf("6개 일치 (%d원) - %d개\n", CORRECT_6_PRICE, winningResultDTO.getCorrect6());

        // 총 상금 계산
        int totalWinningAmount = calculateTotalWinningAmount(winningResultDTO);

        // 수익률 계산 (수익률 = 총 당첨 금액 / 총 구매 금액 * 100)
        double profitRate = ((double) totalWinningAmount / purchaseAmount) * 100;

        // 수익률 출력
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private int calculateTotalWinningAmount(WinningResultDTO winningResultDTO) {
        return (winningResultDTO.getCorrect3() * CORRECT_3_PRICE)
                + (winningResultDTO.getCorrect4() * CORRECT_4_PRICE)
                + (winningResultDTO.getCorrect5() * CORRECT_5_PRICE)
                + (winningResultDTO.getCorrect5withBonus() * CORRECT_5_WITH_BONUS_PRICE)
                + (winningResultDTO.getCorrect6() * CORRECT_6_PRICE);
    }
}
