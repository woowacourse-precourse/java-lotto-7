package lotto.service;

import static lotto.constant.LottoConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, REQUIRED_NUMBER_COUNT);
    }

}
