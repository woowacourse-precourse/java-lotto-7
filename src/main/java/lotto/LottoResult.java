package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    ArrayList<Lotto> purchaseList;
    List<Integer> winnerNumbers;
    int bonusNumber;

    int fifthPrizeCount = 0;
    int fourthPrizeCount = 0 ;
    int thirdPrizeCount = 0;
    int secondPrizeCount = 0;
    int firstPrizeCount = 0;

    double rateOfReturn;

    public LottoResult (ArrayList<Lotto> purchaseList, List<Integer> winnerNumbers, int bonusNumber) {
        this.purchaseList = purchaseList;
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkLottoResult() {
        List<List<Boolean>> resultList = makeResultList();
        List<Integer> winCount = findPrize(resultList);
        boolean secondPrizeYN = false;
        if (winCount.contains(Prize.SECOND.getWinningCount())) {
            int index = winCount.indexOf(Prize.SECOND.getWinningCount());
            int index2 = resultList.get(index).indexOf(false);
            int number = purchaseList.get(index).getNumbers().get(index2);
            secondPrizeYN = findSecondPrize(number);
        }
        prizeCount(winCount, secondPrizeYN);
        getRateOfReturn();
        printResult();
    }

    public List<List<Boolean>> makeResultList() {
        List<List<Boolean>> resultList = new ArrayList<>();
        for (Lotto lotto : purchaseList) {
            List<Boolean> resultEach = compareWithWinningNumber(lotto);
            resultList.add(resultEach);
        }
        return resultList;
    }

    public List<Boolean> compareWithWinningNumber(Lotto lotto) {
        List<Boolean> result = new ArrayList<>();
        for (int n : lotto.getNumbers()) {
            boolean winYN = winnerNumbers.contains(n);
            result.add(winYN);
        }
        return result;
    }

    public List<Integer> findPrize(List<List<Boolean>> resultList) {
        List<Integer> winCount = new ArrayList<>();
        for (List<Boolean> list : resultList) {
            winCount.add(Collections.frequency(list, true));
        }
        return winCount;
    }

    public boolean findSecondPrize(int number) {
        return (number == bonusNumber);
    }

    public void prizeCount(List<Integer> winCount, boolean secondYN) {
        fifthPrizeCount = Collections.frequency(winCount, Prize.FIFTH.getWinningCount());
        fourthPrizeCount = Collections.frequency(winCount, Prize.FOURTH.getWinningCount());
        thirdPrizeCount = Collections.frequency(winCount, Prize.THIRD.getWinningCount());
        firstPrizeCount = Collections.frequency(winCount, Prize.FIRST.getWinningCount());
        if (secondYN) {
            secondPrizeCount ++;
            thirdPrizeCount --;
        }
    }

    public void getRateOfReturn() {
        int purchaseMoney = purchaseList.size() * Constants.PRICE_UNIT;
        int prizeMoney = fifthPrizeCount * Prize.FIFTH.getPrizeMoney()
                + fourthPrizeCount * Prize.FOURTH.getPrizeMoney()
                + thirdPrizeCount * Prize.THIRD.getPrizeMoney()
                + secondPrizeCount * Prize.SECOND.getPrizeMoney()
                + firstPrizeCount * Prize.FIRST.getPrizeMoney();
        float a = (float) prizeMoney / purchaseMoney * 100;
        rateOfReturn = (Math.round(a * 10)/10.0);
    }

    public void printResult() {
        System.out.printf(Constants.PRINT_RESULT_STATICS + "\n");
        System.out.println(Prize.FIFTH.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FIFTH.getPrizeMoney()) + "원)" + " - " + fifthPrizeCount + "개");
        System.out.println(Prize.FOURTH.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FOURTH.getPrizeMoney()) + "원)" + " - " + fourthPrizeCount + "개");
        System.out.println(Prize.THIRD.getPrizeCondition()
                + "(" + String.format("%,d", Prize.THIRD.getPrizeMoney()) + "원)" + " - " + thirdPrizeCount + "개");
        System.out.println(Prize.SECOND.getPrizeCondition()
                + "(" + String.format("%,d", Prize.SECOND.getPrizeMoney()) + "원)" + " - " + secondPrizeCount + "개");
        System.out.println(Prize.FIRST.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FIRST.getPrizeMoney()) + "원)" + " - " + firstPrizeCount + "개");
        System.out.printf(Constants.PRINT_RATE_OF_RETURN, rateOfReturn);
    }
}
