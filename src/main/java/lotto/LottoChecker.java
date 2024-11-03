package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void showLottoResult(int[] totalRanks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + totalRanks[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + totalRanks[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + totalRanks[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalRanks[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + totalRanks[1] + "개");

        int prizeAmount =
                5000 * totalRanks[5] + 50000 * totalRanks[4] + 1500000 * totalRanks[3] + 30000000 * totalRanks[2]
                        + 2000000000 * totalRanks[1];
        int ticketNums = totalRanks[0] + totalRanks[1] + totalRanks[2] + totalRanks[3] + totalRanks[4] + totalRanks[5];
        double rateOfReturn = (double) prizeAmount / (ticketNums * 1000) * 100;

        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }

    public int[] lottoCheck(Customer customer) {
        int[] totalRanks = new int[6];

        for (Lotto lotto : customer.getLottos()) {
            int count = determineRank(lotto);
            int rank = calculateRankFromCount(count);
            totalRanks[rank]++;
        }

        showLottoResult(totalRanks);
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

        for (int i = 0; i < 6; i++) {
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
