package lotto.user;

import java.util.List;
import lotto.committee.WonNumbers;
import lotto.shop.bandingmachine.DrawnNumbers;

public class Result {

    PrizeHistory prizeHistory;
    Integer matchCount = 0;

    public void getResult(WonNumbers wonNumbers) {
        prizeHistory.clean();
        List<DrawnNumbers> drawnNumberPacks = UserStorage.get();
        getPrizes(wonNumbers, drawnNumberPacks);
        print(prizeHistory.getPrizeHistory());
    }

    public void print(PrizeHistory prizeHistory) {
        
    }

    private void getPrizes(WonNumbers wonNumbers, List<DrawnNumbers> drawnNumberPacks) {
        for (DrawnNumbers drawnNumberPack : drawnNumberPacks) {
            getPrize(wonNumbers, drawnNumberPack);
        }
    }

    private void getPrize(WonNumbers wonNumbers, DrawnNumbers drawnNumberPack) {

        List<Integer> wonMains = wonNumbers.getLotto().getNumbers();
        List<Integer> drawnMains = drawnNumberPack.getMainNumbers();
        Integer wonBonus = wonNumbers.getBonus();
        Integer drawnBonus = drawnNumberPack.getBonusNumber();

        matchCount = matchMains(wonMains, drawnMains);
        getCount(matchCount, wonBonus, drawnBonus);
    }

    private void getCount(Integer matchCount, Integer wonBonus, Integer drawnBonus) {
        checkFifth(matchCount);
        checkFourth(matchCount);
        checkSecondThird(matchCount, wonBonus, drawnBonus);
        checkFirst(matchCount);
        checkLost(matchCount);
    }

    private void checkLost(Integer matchCount) {
        if (matchCount < 3 || matchCount > 6) {
            prizeHistory.addLost();
        }
    }

    private void checkFirst(Integer matchCount) {
        if (matchCount == 6) {
            prizeHistory.addFirst();
        }
    }

    private void checkSecondThird(Integer matchCount, Integer wonBonus, Integer drawnBonus) {
        if (matchCount == 5) {
            checkSecond(wonBonus, drawnBonus);
            checkThird(wonBonus, drawnBonus);
        }
    }

    private void checkSecond(Integer wonBonus, Integer drawnBonus) {
        if (wonBonus.equals(drawnBonus)) {
            prizeHistory.addSecond();
        }
    }

    private void checkThird(Integer wonBonus, Integer drawnBonus) {
        if (!wonBonus.equals(drawnBonus)) {
            prizeHistory.addThird();
        }
    }

    private void checkFourth(Integer matchCount) {
        if (matchCount == 4) {
            prizeHistory.addFourth();
        }
    }

    private void checkFifth(Integer matchCount) {
        if (matchCount == 3) {
            prizeHistory.addFifth();
        }
    }

    private Integer matchMains(List<Integer> wonMains, List<Integer> drawnMains) {
        for (Integer drawnMain : drawnMains) {
             matchCount = checkMatch(wonMains, drawnMain);
        }
        return matchCount;
    }

    private Integer checkMatch(List<Integer> wonMains, Integer drawnMain) {
        if(wonMains.contains(drawnMain)) {
            matchCount += 1;
        }
        return matchCount;
    }

}
