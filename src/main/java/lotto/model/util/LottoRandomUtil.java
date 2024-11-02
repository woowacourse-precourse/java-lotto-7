package lotto.model.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomUtil implements RandomUtil {

    @Override
    public List<Integer> issueLottoTicket(Integer minNumber, Integer maxNumber, Integer lottoCount) {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoCount);
    }
}
