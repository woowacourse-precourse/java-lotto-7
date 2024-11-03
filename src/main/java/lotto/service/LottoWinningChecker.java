package lotto.service;

import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.utils.Utils;

public class LottoWinningChecker {
    private HashSet<Integer> winningNumbs;
    private int bonusNumber;

    LottoWinningChecker() {
    }

    public void saveWinningNumbs(List<Integer> validatedWinningNumbs) {
        winningNumbs = new HashSet<>(validatedWinningNumbs);
    }

    public void saveBonusNumber(int bonusNumber) {
        if (winningNumbs.contains(bonusNumber)) {
            throw new IllegalArgumentException(Utils.makeErrorMessage("보너스 번호가 당첨번호와 중복됩니다."));
        }
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkRank(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int winningCount = calculateWinningCount(numbers);

        return decideLottoRank(winningCount, numbers);
    }

    public int[] checkRanks(List<Lotto> lottos) {
        int[] rankCounts = new int[LottoRank.values().length];
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = checkRank(lotto);
            rankCounts[lottoRank.ordinal()]++;
        }
        return rankCounts;
    }

    private int calculateWinningCount(List<Integer> numbers) {
        int winningCount = 0;
        for (Integer number : numbers) {
            if (winningNumbs.contains(number)) {
                winningCount++;
            }
        }

        if (0 <= winningCount && winningCount <= 2) {
            winningCount = 0;
        }

        return winningCount;
    }

    private LottoRank decideLottoRank(int winningCount, List<Integer> numbers) {
        boolean hasBonusNumber = false;
        if (winningCount == 5) {
            hasBonusNumber = checkBonusNumber(numbers);
        }
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getWinningCount() == winningCount && rank.hasBonusNumber() == hasBonusNumber) {
                return rank;
            }
        }
        return LottoRank.NONE; //도달 하지 않는다.
    }

    private boolean checkBonusNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number == bonusNumber);
    }

    public HashSet<Integer> getWinningNumbs() {
        return winningNumbs;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
