package lotto;

import java.util.List;

public class LottoResult {
    private static int firstRankCount;
    private static int secondRankCount;
    private static int thirdRankCount;
    private static int fourthRankCount;
    private static int fifthRankCount;

    private static final LottoRank FIRST_RANK = LottoRank.FIRST;
    private static final LottoRank SECOND_RANK = LottoRank.SECOND;
    private static final LottoRank THIRD_RANK = LottoRank.THIRD;
    private static final LottoRank FOURTH_RANK = LottoRank.FOURTH;
    private static final LottoRank FIFTH_RANK = LottoRank.FIFTH;

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

    public static void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(FIRST_RANK.getDescription() + firstRankCount + "개");
        System.out.println(SECOND_RANK.getDescription() + secondRankCount + "개");
        System.out.println(THIRD_RANK.getDescription() + thirdRankCount + "개");
        System.out.println(FOURTH_RANK.getDescription() + fourthRankCount + "개");
        System.out.println(FIFTH_RANK.getDescription() + fifthRankCount + "개");
    }
}
