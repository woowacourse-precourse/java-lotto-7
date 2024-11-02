package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningNumber;

public class StatisticCalculator {

    public static List<Integer> calculateStatistics(User user, WinningNumber winningNumber) {
        List<Integer> accords = initializeAccords();
        Lottos userLottos = user.getLottos();

        for (Lotto lotto : userLottos.getLottos()) {
            int matchCount = calculateMatchCount(lotto, winningNumber.getWinningLotto());
            int index = determineIndex(matchCount, lotto, winningNumber.getBonusNumber());
            if (index != -1) {
                updateAccords(accords, index);
            }
        }
        return accords;
    }

    private static List<Integer> initializeAccords() {
        return new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    private static int calculateMatchCount(Lotto userLotto, Lotto winningLotto) {
        int count = 0;
        for (int number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int determineIndex(int matchCount, Lotto userLotto, BonusNumber bonusNumber) {
        if (matchCount == 3) {
            return 0;
        }
        if (matchCount == 4) {
            return 1;
        }
        if (matchCount == 6) {
            return 4;
        }
        if (matchCount == 5) {
            return handleFiveMatches(userLotto, bonusNumber);
        }
        return -1;
    }

    private static int handleFiveMatches(Lotto userLotto, BonusNumber bonusNumber) {
        if (containsBonusNumber(userLotto, bonusNumber)) {
            return 3;
        }
        return 2;
    }

    private static boolean containsBonusNumber(Lotto userLotto, BonusNumber bonusNumber) {
        return userLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private static void updateAccords(List<Integer> accords, int index) {
        accords.set(index, accords.get(index) + 1);
    }
}
