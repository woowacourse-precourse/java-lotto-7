package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtils {

    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> notImmutableNumber = new ArrayList<>(lottoNumber);
        Collections.sort(notImmutableNumber);
        return lottoNumber;
    }
}
