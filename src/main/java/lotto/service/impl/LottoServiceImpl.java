package lotto.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;


public class LottoServiceImpl implements LottoService {

    @Override
    public List<Lotto> purchaseLottoBundle(int purchaseCount) {

        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_TOTAL_COUNT));
            lottoBundle.add(lotto);
        }
        return lottoBundle;
    }

}
