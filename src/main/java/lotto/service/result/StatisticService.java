package lotto.service.result;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;

public class StatisticService {

    public List<Integer> statisticsCalculator(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        return calculate(user, winningLotto, bonusNumber);
    }

    private List<Integer> calculate(User user, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> accords = initializeAccords();
        Lottos userLottos = user.getLottos();

        for (Lotto lotto : userLottos.getLottos()) {
            int matchCount = calculateMatchCount(lotto, winningLotto);
            int index = determineIndex(matchCount, lotto, bonusNumber);
            if (index != -1) {
                updateAccords(accords, index);
            }
        }
        return accords;
    }

    private List<Integer> initializeAccords() {
        return new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    private int calculateMatchCount(Lotto userLotto, Lotto winningLotto) {
        int count = 0;
        for (int number : userLotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private int determineIndex(int matchCount, Lotto userLotto, BonusNumber bonusNumber) {
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

    private int handleFiveMatches(Lotto userLotto, BonusNumber bonusNumber) {
        if (containsBonusNumber(userLotto, bonusNumber)) {
            return 3;
        }
        return 2;
    }


    private boolean containsBonusNumber(Lotto userLotto, BonusNumber bonusNumber) {
        return userLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private void updateAccords(List<Integer> accords, int index) {
        accords.set(index, accords.get(index) + 1);
    }
}
