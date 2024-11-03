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

    public List<Integer> lottoCheck(Customer customer) {
        List<Integer> totalRanks = new ArrayList<>();

        for (Lotto lotto : customer.getLottos()) {
            int count = determineRank(lotto);
            int rank = calculateRankFromCount(count);
            totalRanks.add(rank);
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
