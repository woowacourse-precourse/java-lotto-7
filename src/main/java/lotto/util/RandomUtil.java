package lotto.util;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    private static final int DEFAULT_COUNT = 6;

    public static List<Integer> getLottoNumbers(int count) {
        return Randoms.pickUniqueNumbersInRange(1, 45, count);
    }

    public static List<Integer> getLottoNumbers() {
        return getLottoNumbers(DEFAULT_COUNT);
    }

    public static int getBonusNumber(List<Integer> lottoNumbers) {
        int bonusNumber = Randoms.pickNumberInRange(1, 45);
        if (lottoNumbers.contains(bonusNumber)) {
            return getBonusNumber(lottoNumbers);
        }
        return bonusNumber;
    }
}
