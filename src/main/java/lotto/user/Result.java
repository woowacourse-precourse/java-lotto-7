package lotto.user;

import java.util.List;
import lotto.MessageCenter;
import lotto.committee.WonNumbers;
import lotto.shop.bandingmachine.DrawnNumbers;

public class Result {

    PrizeHistory prizeHistory = new PrizeHistory();
    String prizeResult;

    public PrizeHistory getResult(WonNumbers wonNumbers) {
        prizeHistory.clean();
        List<DrawnNumbers> drawnNumberPacks = UserStorage.getNumbers();
        getPrizes(wonNumbers, drawnNumberPacks);
        print(prizeHistory.getPrizeHistory());

        return prizeHistory;
    }

    public void print(PrizeHistory prizeHistory) {
        prizeHistory.getPrizeHistory();
        MessageCenter.NEW_LINE.print();
        MessageCenter.RESULT.print();
        printPrizes(prizeHistory);
    }

    private void printPrizes(PrizeHistory prizeHistory) {
        printFifth(prizeHistory.getFifth());
        printFourth(prizeHistory.getFourth());
        printThird(prizeHistory.getThird());
        printSecond(prizeHistory.getSecond());
        printFirst(prizeHistory.getFirst());
    }

    public String getMsgEnd(Integer count) {
        String msgEnd = "";
        msgEnd += count;
        msgEnd += MessageCenter.RESULT_END.get();
        return msgEnd;
    }

    private void printFirst(Integer count) {
        System.out.println(MessageCenter.RESULT_FIRST.get() + getMsgEnd(count));
    }

    private void printSecond(Integer count) {
        prizeResult = "";
        prizeResult = MessageCenter.RESULT_SECOND.get() + getMsgEnd(count);
        System.out.println(prizeResult);
    }

    private void printThird(Integer count) {
        prizeResult = "";
        prizeResult = MessageCenter.RESULT_THIRD.get() + getMsgEnd(count);
        System.out.println(prizeResult);
    }

    private void printFourth(Integer count) {
        prizeResult = "";
        prizeResult = MessageCenter.RESULT_FOURTH.get() + getMsgEnd(count);
        System.out.println(prizeResult);
    }

    private void printFifth(Integer count) {
        prizeResult = "";
        prizeResult = MessageCenter.RESULT_FIFTH.get() + getMsgEnd(count);
        System.out.println(prizeResult);
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

        Integer matchCount = matchMains(wonMains, drawnMains);
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
        Integer matchCount = 0;
        for (Integer drawnMain : drawnMains) {
             matchCount = checkMatch(matchCount, wonMains, drawnMain);
        }
        return matchCount;
    }

    private Integer checkMatch(Integer matchCount, List<Integer> wonMains, Integer drawnMain) {
        if(wonMains.contains(drawnMain)) {
            matchCount += 1;
        }
        return matchCount;
    }

}
