package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    static List<Lotto> lottoList = new ArrayList<>();
    static int[] matchResult = new int[5];

    public static List<Lotto> generateLotto(int number) {
        for (int i = 0; i < number; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public static int[] matchLotto(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottolist, int number) {

        for (Lotto lotto : lottolist) {
            int matchCount = matchNumbers(lotto.getLottoNumbers(), winningNumbers);
            makeResult(matchCount, matchResult, lotto.getLottoNumbers(), bonusNumber);
        }
        return matchResult;
    }

    private static int matchNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
        int cnt = 0;
        for (int number : winningNumbers) {
            if (lotto.contains(number)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static int[] makeResult(int matchCount, int[] matchResult, List<Integer> lotto, int bonusNumber) {
        if (matchCount == 6) {
            matchResult[0]++;
            return matchResult;
        }
        if (matchCount == 5) {
            if (lotto.contains(bonusNumber)) {
                matchResult[1]++;
                return matchResult;
            }
            matchResult[2]++;
            return matchResult;
        }
        if (matchCount == 4) {
            matchResult[3]++;
            return matchResult;
        }
        if (matchCount == 3) {
            matchResult[4]++;
            return matchResult;
        }
        return matchResult;
    }

    public static double calculateProfitRate(int[] result, int inputPrice) {
        int profit = 0;

        profit += 2000000000 * result[0];
        profit += 30000000 * result[1];
        profit += 1500000 * result[2];
        profit += 50000 * result[3];
        profit += 5000 * result[4];

        return ((double) profit / inputPrice) * 100;
    }
}
