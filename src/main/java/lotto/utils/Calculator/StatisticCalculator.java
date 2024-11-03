package lotto.utils.Calculator;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Constants;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.domain.WinningNumber;

public class StatisticCalculator {
    private final static int NO_MATCH = -1;
    private final static int THREE_MATCHES = 3;
    private final static int FOUR_MATCHES = 4;
    private final static int FIVE_MATCHES = 5;
    private final static int SIX_MATCHES = 6;

    public static List<Integer> calculateStatistics(User user, WinningNumber winningNumber) {
        List<Integer> accords = initializeAccords();
        Lottos userLottos = user.getLottos();

        for (Lotto lotto : userLottos.getLottos()) {
            int matchCount = calculateMatchCount(lotto, winningNumber.getWinningLotto());
            int index = determineIndex(matchCount, lotto, winningNumber.getBonusNumber());
            if (index != NO_MATCH) {
                updateAccords(accords, index);
            }
        }
        return accords;
    }

    private static List<Integer> initializeAccords() {
        return new ArrayList<>(List.of(Constants.ZERO.getValue(), Constants.ZERO.getValue(), Constants.ZERO.getValue(),
                Constants.ZERO.getValue(), Constants.ZERO.getValue()));
    }

    private static int calculateMatchCount(Lotto userLotto, Lotto winningLotto) {
        int count = Constants.ZERO.getValue();
        for (int number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private static int determineIndex(int matchCount, Lotto userLotto, BonusNumber bonusNumber) {
        if (matchCount == THREE_MATCHES) {
            return 0;
        }
        if (matchCount == FOUR_MATCHES) {
            return 1;
        }
        if (matchCount == SIX_MATCHES) {
            return 4;
        }
        if (matchCount == FIVE_MATCHES) {
            return handleFiveMatches(userLotto, bonusNumber);
        }
        return NO_MATCH;
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
