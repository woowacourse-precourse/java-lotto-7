package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    private static final int FIRST_PRIZE_AMOUNT = 2_000_000_000;
    private static final int SECOND_PRIZE_AMOUNT = 30_000_000;
    private static final int THIRD_PRIZE_AMOUNT = 1_500_000;
    private static final int FOURTH_PRIZE_AMOUNT = 50_000;
    private static final int FIFTH_PRIZE_AMOUNT = 5_000;

    private static final int MATCH_COUNT_FOR_FIRST_PRIZE = 6;
    private static final int MATCH_COUNT_FOR_SECOND_PRIZE = 5;
    private static final int MATCH_COUNT_FOR_THIRD_PRIZE = 5;
    private static final int MATCH_COUNT_FOR_FOURTH_PRIZE = 4;
    private static final int MATCH_COUNT_FOR_FIFTH_PRIZE = 3;

    private static int finalPrize;
    private static List<Integer> finalMatchNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

    public static int calculatePrize(List<Integer> userLottoNumbers, List<Integer> winningLottoNumber, int bonusNumber) {
        int matchedNumbers = countMatchedNumbers(userLottoNumbers, winningLottoNumber);
        boolean hasBonusNumber = userLottoNumbers.contains(bonusNumber);

        if (matchedNumbers == MATCH_COUNT_FOR_FIRST_PRIZE) {
            finalPrize += FIRST_PRIZE_AMOUNT;
            finalMatchNumbers.set(0, finalMatchNumbers.get(0) + 1);
            return finalPrize;
        }
        if (matchedNumbers == MATCH_COUNT_FOR_SECOND_PRIZE && hasBonusNumber) {
            finalPrize += SECOND_PRIZE_AMOUNT;
            finalMatchNumbers.set(1, finalMatchNumbers.get(1) + 1);
            return finalPrize;
        }
        if (matchedNumbers == MATCH_COUNT_FOR_THIRD_PRIZE) {
            finalPrize += THIRD_PRIZE_AMOUNT;
            finalMatchNumbers.set(2, finalMatchNumbers.get(2) + 1);
            return finalPrize;
        }
        if (matchedNumbers == MATCH_COUNT_FOR_FOURTH_PRIZE) {
            finalPrize += FOURTH_PRIZE_AMOUNT;
            finalMatchNumbers.set(3, finalMatchNumbers.get(3) + 1);
            return finalPrize;
        }
        if (matchedNumbers == MATCH_COUNT_FOR_FIFTH_PRIZE) {
            finalPrize += FIFTH_PRIZE_AMOUNT;
            finalMatchNumbers.set(4, finalMatchNumbers.get(4) + 1);
            return finalPrize;
        }
        return 0;
    }

    private static int countMatchedNumbers(List<Integer> userLottoNumbers, List<Integer> winningLottoNumber) {
        return (int) userLottoNumbers.stream().filter(winningLottoNumber::contains).count();
    }

    public static List<Integer> getFinalMatchNumbers() {
        return finalMatchNumbers;
    }

    public static void initialize() {
        finalPrize = 0;
        finalMatchNumbers = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
    }
}