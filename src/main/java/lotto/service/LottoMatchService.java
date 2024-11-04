package lotto.service;

import java.util.List;

public class LottoMatchService {
    public static int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> userNumbers) {
        int count = 0;
        for (int userNumber : userNumbers) {
            if (lottoNumbers.contains(userNumber)) {
                count++;
            }
        }
        return count;
    }

    public static boolean calculateBonusMatch(int matchCount, int bonusNumber, List<Integer> userNumbers) {
        if (matchCount == 5) {
            return userNumbers.contains(bonusNumber);
        }
        return false;
    }
}
