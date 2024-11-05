package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.domain.Lotto;


public abstract class LottoGenerator {
    public static Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_MIN_RANGE,
                LottoConstant.LOTTO_NUMBER_MAX_RANGE,
                LottoConstant.LOTTO_NUMBER_COUNT));
    }

    public static List<Lotto> getLottos(int count) {
        List<Lotto> lottos = new LinkedList<>();
        while (count-- > 0) {
            lottos.add(getLotto());
        }
        return lottos;
    }
}
