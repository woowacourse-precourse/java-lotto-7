package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    public List<Lotto> initLotto(int payCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }
}
