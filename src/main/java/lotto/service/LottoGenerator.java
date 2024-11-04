package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoConstants;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                LottoConstants.LOTTO_MIN_NUMBER.getValue(),
                LottoConstants.LOTTO_MAX_NUMBER.getValue(),
                LottoConstants.LOTTO_NUMBER_COUNT.getValue()
        );
    }
}
