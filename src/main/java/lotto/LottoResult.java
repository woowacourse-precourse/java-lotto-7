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

        if (winCount.contains(5)) {
            int index = winCount.indexOf(5);
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
        fifthPrize = Collections.frequency(winCount, 3);
        fourthPrize = Collections.frequency(winCount, 4);
        thirdPrize = Collections.frequency(winCount, 5);
        firstPrize = Collections.frequency(winCount, 6);
        if (secondYN) {
            secondPrize ++;
            thirdPrize --;
        }
    }

    public void getRateOfReturn() {
        int purchaseMoney = purchaseList.size() * 1000;
        int prizeMoney = fifthPrize * 5000 + fourthPrize * 50000 + thirdPrize * 1500000
                + secondPrize * 30000000 + firstPrize * 2000000000;
        float a = (float) prizeMoney / purchaseMoney * 100;
        rateOfReturn = (Math.round(a * 10)/10.0);


    }

    public void printResult() {
        System.out.println(Prize.FIFTH.getPrizeCondition() + " - " + fifthPrize + "개");
        System.out.println(Prize.FOURTH.getPrizeCondition() + " - " + fourthPrize + "개");
        System.out.println(Prize.THIRD.getPrizeCondition() + " - " + thirdPrize + "개");
        System.out.println(Prize.SECOND.getPrizeCondition() + " - " + secondPrize + "개");
        System.out.println(Prize.FIRST.getPrizeCondition() + " - " + firstPrize + "개");
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
