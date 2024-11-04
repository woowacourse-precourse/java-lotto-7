package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    ArrayList<Lotto> purchaseList;
    List<Integer> winnerNumbers;
    int bonusNumber;

    int fifthPrize = 0;
    int fourthPrize = 0 ;
    int thirdPrize = 0;
    int secondPrize = 0;
    int firstPrize = 0;

    double rateOfReturn;

    public LottoResult (ArrayList<Lotto> purchaseList, List<Integer> winnerNumbers, int bonusNumber) {
        this.purchaseList = purchaseList;
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void checkLottoResult() {
        List<List<Boolean>> resultList = makeResultList();
        List<Integer> winCount = findPrize(resultList);
        boolean secondYN = false;

        if (winCount.contains(Prize.SECOND.getWinningCount())) {
            int index = winCount.indexOf(Prize.SECOND.getWinningCount());
            int index2 = resultList.get(index).indexOf(false);
            int number = purchaseList.get(index).getNumbers().get(index2);
            secondYN = findSecondPrize(number);
        }

        prizeCount(winCount, secondYN);
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
        fifthPrize = Collections.frequency(winCount, Prize.FIFTH.getWinningCount());
        fourthPrize = Collections.frequency(winCount, Prize.FOURTH.getWinningCount());
        thirdPrize = Collections.frequency(winCount, Prize.THIRD.getWinningCount());
        firstPrize = Collections.frequency(winCount, Prize.FIRST.getWinningCount());
        if (secondYN) {
            secondPrize ++;
            thirdPrize --;
        }
    }

    public void getRateOfReturn() {
        int purchaseMoney = purchaseList.size() * Constants.PRICE_UNIT;
        int prizeMoney = fifthPrize * Prize.FIFTH.getPrizeMoney()
                + fourthPrize * Prize.FOURTH.getPrizeMoney()
                + thirdPrize * Prize.THIRD.getPrizeMoney()
                + secondPrize * Prize.SECOND.getPrizeMoney()
                + firstPrize * Prize.FIRST.getPrizeMoney();
        float a = (float) prizeMoney / purchaseMoney * 100;
        rateOfReturn = (Math.round(a * 10)/10.0);
    }

    public void printResult() {
        System.out.printf(Constants.PRINT_RESULT_STATICS + "\n");
        System.out.println(Prize.FIFTH.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FIFTH.getPrizeMoney()) + "원)" + " - " + fifthPrize + "개");
        System.out.println(Prize.FOURTH.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FOURTH.getPrizeMoney()) + "원)" + " - " + fourthPrize + "개");
        System.out.println(Prize.THIRD.getPrizeCondition()
                + "(" + String.format("%,d", Prize.THIRD.getPrizeMoney()) + "원)" + " - " + thirdPrize + "개");
        System.out.println(Prize.SECOND.getPrizeCondition()
                + "(" + String.format("%,d", Prize.SECOND.getPrizeMoney()) + "원)" + " - " + secondPrize + "개");
        System.out.println(Prize.FIRST.getPrizeCondition()
                + "(" + String.format("%,d", Prize.FIRST.getPrizeMoney()) + "원)" + " - " + firstPrize + "개");
        System.out.printf(Constants.PRINT_RATE_OF_RETURN, rateOfReturn);
    }
}
