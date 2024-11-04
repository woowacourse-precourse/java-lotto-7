package model;

import lotto.Winning;

import java.util.*;

public class resultMaker {
    private resultMaker() {}

    public static Map<Winning, Integer> makeResult(ArrayList<List<Integer>> lottos, String[] myLottoNumbers, int bonus) {
        Map<Winning, Integer> resultCount = new EnumMap<>(Winning.class);
        for (Winning w : Winning.values()) {
            resultCount.put(w, 0);
        }

        for (List<Integer> lotto : lottos) {
            Winning result = resultMaker.checkWinning(lotto, bonus, myLottoNumbers);
            resultCount.put(result, resultCount.get(result) + 1);
        }
        return resultCount;
    }

    public static double makeProfit(Map<Winning, Integer> makeResult, int budget) {
        int totalPrize = 0;

        // 각 당첨 항목별 총 당첨금을 계산하여 누적
        for (Map.Entry<Winning, Integer> entry : makeResult.entrySet()) {
            Winning winning = entry.getKey();
            int count = entry.getValue();
            totalPrize += winning.getWinnings() * count;
        }

        // 수익률 = (총 상금 / 예산) * 100
        return ((double) totalPrize / budget) * 100;
    }


    private static Winning checkWinning(List<Integer> winningNumbers, int bonusNumber, String[] myLottoNumbers) {
        int matchCount = 0;
        ArrayList<Integer> myLotto = formatLottoNumbers(myLottoNumbers);
        boolean bonusMatch = myLotto.contains(bonusNumber);

        for (int number : myLotto) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return Winning.getWinningByMatch(matchCount, bonusMatch);
    }

    private static ArrayList<Integer> formatLottoNumbers(String[] myLottoNumbers) {
        ArrayList<Integer> myLotto = new ArrayList<>();
        for(String str : myLottoNumbers) {
            myLotto.add(Integer.parseInt(str));
        }
        return myLotto;
    }
}

