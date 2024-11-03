package lotto;

import java.util.List;

public class LottoResult {
    private static int firstRankCount;
    private static int secondRankCount;
    private static int thirdRankCount;
    private static int fourthRankCount;
    private static int fifthRankCount;

    public static void countFirstRank(List<Lotto> lottoSets, Lotto winningNumbers) {
        firstRankCount = 0;
        for (Lotto lotto : lottoSets) {
            int matchingCount = lotto.countMatchingNumbersWithSameObject(winningNumbers);
            if (matchingCount == 6) {
                firstRankCount++;
            }
        }
    }

    public static void countSecondRank(List<Lotto> lottoSets, Lotto winningNumbers, List<Integer> bonusNumber) {
        secondRankCount = 0;
        for (Lotto lotto : lottoSets) {
            int matchingCount = lotto.countMatchingNumbersWithSameObject(winningNumbers);
            int matchingCountWithBonusNumber = lotto.countMatchingNumbersWithIntegerList(bonusNumber);
            if (matchingCount == 5 && matchingCountWithBonusNumber == 1) {
                secondRankCount++;
            }
        }
    }

    public static void countThirdRank(List<Lotto> lottoSets, Lotto winningNumbers, List<Integer> bonusNumber) {
        thirdRankCount = 0;
        for (Lotto lotto : lottoSets) {
            int matchingCount = lotto.countMatchingNumbersWithSameObject(winningNumbers);
            int matchingCountWithBonusNumber = lotto.countMatchingNumbersWithIntegerList(bonusNumber);
            if (matchingCount == 5 && matchingCountWithBonusNumber == 0) {
                thirdRankCount++;
            }
        }
    }

    public static void countFourthRank(List<Lotto> lottoSets, Lotto winningNumbers) {
        fourthRankCount = 0;
        for (Lotto lotto : lottoSets) {
            int matchingCount = lotto.countMatchingNumbersWithSameObject(winningNumbers);
            if (matchingCount == 4) {
                fourthRankCount++;
            }
        }
    }

    public static void countFifthRank(List<Lotto> lottoSets, Lotto winningNumbers) {
        fifthRankCount = 0;
        for (Lotto lotto : lottoSets) {
            int matchingCount = lotto.countMatchingNumbersWithSameObject(winningNumbers);
            if (matchingCount == 3) {
                fifthRankCount++;
            }
        }
    }
}
