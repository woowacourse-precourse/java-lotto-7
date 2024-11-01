package lotto.service.lotto.impl;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.service.lotto.LottoService;

import java.util.ArrayList;
import java.util.List;


public class LottoServiceImpl implements LottoService {

    @Override
    public List<Lotto> createLottoBundle(int purchaseCount) {

        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_TOTAL_COUNT));
            lottoBundle.add(lotto);
        }
        return lottoBundle;
    }

    @Override
    public Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
