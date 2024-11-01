package lotto.model.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConst;

public class GeneraterLotto {

    public static List<Lotto> generateLotto(List<Lotto> lottos,int lottoCount) {

        for (int i = 0; i < lottoCount; i++) {

            List<Integer> lottoNumbers = new ArrayList<>();

            for (int j = 0; j < LottoConst.LOTTONUMBERCOUNT.getLottoConst(); j++) {
                int randomNum = Randoms.pickNumberInRange(LottoConst.STARTRANGENUMBER.getLottoConst(),
                        LottoConst.ENDRANGENUMBER.getLottoConst());
                lottoNumbers.add(randomNum);
            }

            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

}
