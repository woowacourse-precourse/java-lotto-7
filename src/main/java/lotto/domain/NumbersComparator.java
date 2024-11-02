package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class NumbersComparator {

    private static final int TOTAL_RANK_TYPES = 5;

    private final List<Lotto> myLottos;

    private final WinningNumbers winningNumbers;

    public NumbersComparator(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.myLottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int[] determineRank() {
        int[] rank = new int[TOTAL_RANK_TYPES];
        for (int i=0; i<myLottos.size(); i++) {
            List<Integer> myNumbers = myLottos.get(i).getNumbers();
            int matchCount = countMatchedNumbers(myNumbers);
        }

        return rank;
    }

    private int countMatchedNumbers(List<Integer> myNumbers) {
        return (int) myNumbers.stream()
                .filter(winningNumbers.getWinningNumbers()::contains)
                .count();
    }
}
