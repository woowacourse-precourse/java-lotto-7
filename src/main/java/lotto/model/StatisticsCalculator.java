package lotto.model;

import lotto.Lotto;
import lotto.model.enums.RankMessage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StatisticsCalculator {
    public static List<LottoResult> checkLotto(List<Lotto> lottos, WinningLotto winningLotto) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int winningResult = checkWinningNumbers(lotto, winningLotto);
            boolean bonusResult = checkBonusNumber(lotto, winningLotto);

            lottoResults.add(new LottoResult(winningResult, bonusResult));
        }

        return lottoResults;
    }

    private static int checkWinningNumbers(Lotto lotto, WinningLotto winningLotto) {
        int winningResult = 0;

        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                winningResult += 1;
            }
        }

        return winningResult;
    }

    private static boolean checkBonusNumber(Lotto lotto, WinningLotto winningLotto) {
        for (int number : lotto.getNumbers()) {
            if (number == winningLotto.getBonusNumber()) {

                return true;
            }
        }

        return false;
    }

    public static void calculateRankCounts(List<LottoResult> results, RankStorage rankStorage) {
        for (LottoResult lottoResult : results) {
            int rank = fixRank(lottoResult.getWinningResult(), lottoResult.isBonusResult());

            if (rank > 0) {
                rankStorage.increaseRankCount(rank);
            }
        }
    }

    private static int fixRank(int winningResult, boolean bonusResult) {
        if (winningResult == 6) {
            return 1;
        } else if (winningResult == 5 && bonusResult) {
            return 2;
        } else if (winningResult == 5) {
            return 3;
        } else if (winningResult == 4) {
            return 4;
        } else if (winningResult == 3) {
            return 5;
        }
        return 0;
    }

    public static double calculateRateReturn(LottoAmount lottoAmount, RankStorage rankStorage) {
        int totalReturn = 0;
        for (RankMessage rankMessage : RankMessage.values()) {
            totalReturn += rankMessage.getPrize() * rankStorage.getRankCount(rankMessage.getRank());
        }

        double rate = (double) totalReturn / lottoAmount.getAmount() * 100;

        return roundOff(rate);
    }

    private static double roundOff(double number) {
        BigDecimal roundedNumber = new BigDecimal(number).setScale(1, RoundingMode.HALF_UP);

        return roundedNumber.doubleValue();
    }
}
