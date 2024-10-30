package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoUtils {

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}
