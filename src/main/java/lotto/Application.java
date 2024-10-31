package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static List<List<Integer>> generateLottoNumbers(int lottoAmount) {
        List<List<Integer>> userLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> userLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLottoNumber.sort(Comparator.naturalOrder());
            userLottoNumbers.add(userLottoNumber);
        }
        return userLottoNumbers;
    }

    public static void checkLottoMatch(List<List<Integer>> userLottoNumbers, List<Integer> lottoWinningNumber, int lottoBonusNumber) {
        boolean isBonusNumberMatched = false;
        for (List<Integer> userLottoNumber: userLottoNumbers) {
            int winningNumberCount = compareLottoNumbers(userLottoNumber, lottoWinningNumber);
            if (winningNumberCount == 5) {
                isBonusNumberMatched = compareBonusNumber(userLottoNumber, lottoBonusNumber);
            }
        }
    }

    public static int compareLottoNumbers(List<Integer> userLottoNumber, List<Integer> lottoWinningNumber) {
        int winningNumberCount = 0;
        for (int number : lottoWinningNumber) {
            if (userLottoNumber.contains(number)) {
                winningNumberCount +=  1;
            }
        }
        return winningNumberCount;
    }

    public static boolean compareBonusNumber(List<Integer> userLottoNumber, int lottoBonusNumber) {
        return userLottoNumber.contains(lottoBonusNumber);
    }

    public static void main(String[] args) {

    }
}
