package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Application {
    static List<List<Integer>> userLottoNumbers = new ArrayList<>();
    static Map<Rank, Integer> lottoPrizeCount = new LinkedHashMap<>() {{
       put(Rank.FIRST, 0);
       put(Rank.SECOND, 0);
       put(Rank.THIRD, 0);
       put(Rank.FOURTH, 0);
       put(Rank.FIFTH, 0);
    }};
    static double lottoProfit;

    public static void generateLottoNumbers(int lottoAmount) {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottoNumber.sort(Comparator.naturalOrder());
            userLottoNumbers.add(userLottoNumber);
        }
    }

    public static void checkLottoMatch(List<Integer> lottoWinningNumber, int lottoBonusNumber) {
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            boolean isBonusNumberMatched = false;
            int winningNumberCount = compareLottoNumbers(userLottoNumber, lottoWinningNumber);
            if (winningNumberCount == 5) {
                isBonusNumberMatched = compareBonusNumber(userLottoNumber, lottoBonusNumber);
            }
            countLottoRank(winningNumberCount, isBonusNumberMatched);
        }
    }

    public static void countLottoRank(int winningNumberCount, boolean isBonusNumberMatched) {
        Rank value = Rank.valueOf(winningNumberCount, isBonusNumberMatched);
        if (value != null) {
            lottoPrizeCount.put(value, lottoPrizeCount.get(value) + 1);
        }
    }

    public static int compareLottoNumbers(List<Integer> userLottoNumber, List<Integer> lottoWinningNumber) {
        int winningNumberCount = 0;
        for (int number : lottoWinningNumber) {
            if (userLottoNumber.contains(number)) {
                winningNumberCount += 1;
            }
        }
        return winningNumberCount;
    }

    public static boolean compareBonusNumber(List<Integer> userLottoNumber, int lottoBonusNumber) {
        return userLottoNumber.contains(lottoBonusNumber);
    }

    public static double calculateLottoProfit(int lottoPurchasePrice) {
        int lottoTotalPrice = 0;
        for (Rank rank : lottoPrizeCount.keySet()) {
            if (lottoPrizeCount.get(rank) != 0) {
                lottoTotalPrice += rank.getPrizeMoney() * lottoPrizeCount.get(rank);
            }
        }
        return (double) lottoTotalPrice / lottoPurchasePrice * 100;
    }

    public static void main(String[] args) {

    }
}
