package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, 6
        ).stream().sorted().toList();
    }
}