package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.NumberConstants;

public class LottoDrawer {
    public List<Integer> drawRandomNumbers(){
        return Randoms.
                pickUniqueNumbersInRange(NumberConstants.START_NUMBER.getNumber(),
                NumberConstants.END_NUMBER.getNumber(),
                NumberConstants.LOTTO_COUNT.getNumber());
    }
}
