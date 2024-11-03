package lotto.util.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoRandomUtil implements RandomUtil {

    private static LottoRandomUtil lottoRandomUtil;

    private LottoRandomUtil() {
    }

    public static LottoRandomUtil getLottoRandomUtil() {
        if (lottoRandomUtil == null) {
            lottoRandomUtil = new LottoRandomUtil();
        }
        return lottoRandomUtil;
    }

    @Override
    public List<Integer> issueLottoTicket(Integer minNumber, Integer maxNumber, Integer lottoCount) {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoCount);
    }
}
