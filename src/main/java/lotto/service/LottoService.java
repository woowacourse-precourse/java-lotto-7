package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public int getLottoQuantity(int money) {
        return money / 1000;
    }

    public List<Lotto> issueLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

}
