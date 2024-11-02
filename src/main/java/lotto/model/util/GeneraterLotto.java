package lotto.model.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.common.LottoConst;
import lotto.model.lotto.Lotto;

public class GeneraterLotto {

    public static List<Lotto> generateLotto(List<Lotto> lottos, int lottoCount) {

        for (int i = 0; i < lottoCount; i++) {

            List<Integer> lottoNumbers =
                    Randoms.pickUniqueNumbersInRange(LottoConst.STARTRANGENUMBER.getLottoConst(),
                            LottoConst.ENDRANGENUMBER.getLottoConst(), LottoConst.LOTTONUMBERCOUNT.getLottoConst());

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

}
