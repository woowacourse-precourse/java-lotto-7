package lotto;

import java.util.List;

public class LottoChecker {
    private static final int LOTTO_1_PRIZE = 2000000000;
    private static final int LOTTO_2_PRIZE = 30000000;
    private static final int LOTTO_3_PRIZE = 1500000;
    private static final int LOTTO_4_PRIZE = 50000;
    private static final int LOTTO_5_PRIZE = 5000;
    private static final int TICKET_PRICE = 1000;

    private static final int LOTTO_NUMS_COUNT = 6;

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void lottoCheck(Customer customer) {
        int[] totalRanks = lottoRankCheck(customer);
        showLottoResult(totalRanks);
    }

    public double calculateRateOfReturn(int[] totalRanks) {
        int prizeAmount = LOTTO_5_PRIZE * totalRanks[5] + LOTTO_4_PRIZE * totalRanks[4] + LOTTO_3_PRIZE * totalRanks[3]
                + LOTTO_2_PRIZE * totalRanks[2] + LOTTO_1_PRIZE * totalRanks[1];
        int ticketNums = totalRanks[0] + totalRanks[1] + totalRanks[2] + totalRanks[3] + totalRanks[4] + totalRanks[5];
        return (double) prizeAmount / (ticketNums * TICKET_PRICE) * 100;
    }

    public void showLottoResult(int[] totalRanks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalRanks[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + totalRanks[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalRanks[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalRanks[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalRanks[1] + "개");

        double rateOfReturn = calculateRateOfReturn(totalRanks);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    public int[] lottoRankCheck(Customer customer) {
        int[] totalRanks = new int[LOTTO_NUMS_COUNT];

        for (Lotto lotto : customer.getLottos()) {
            int count = determineRank(lotto);
            int rank = calculateRankFromCount(count);
            totalRanks[rank]++;
        }

        return totalRanks;
    }

    public int calculateRankFromCount(int rank) {
        if (rank == 15) {
            return 2;
        }

        if (rank == 6) {
            return 1;
        }

        if (rank == 5) {
            return 3;
        }

        if (rank % 10 == 4) {
            return 4;
        }

        if (rank % 10 == 3) {
            return 5;
        }

        return 0;
    }

    public int determineRank(Lotto lotto) {
        int count = 0;

        for (int i = 0; i < LOTTO_NUMS_COUNT; i++) {
            int num = lotto.getNumbers().get(i);
            count = isWinningLotto(count, num);
        }

        return count;
    }

    public int isWinningLotto(int count, int num) {
        if (winningNumbers.contains(num)) {
            count++;
        }
        if (bonusNumber == num) {
            count += 10;
        }

        return count;
    }
}
