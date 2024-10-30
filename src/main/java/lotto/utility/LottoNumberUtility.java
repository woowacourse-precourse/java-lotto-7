package lotto.utility;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.enums.LottoCriteria;

public class LottoNumberUtility {

    public static List<Integer> lottoRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(LottoCriteria.MIN_LOTTO_NUM.getCriteriaVal(),
                LottoCriteria.MAX_LOTTO_COUNT.getCriteriaVal(), LottoCriteria.WINNING_NUMBER_COUNT.getCriteriaVal());
    }
}
