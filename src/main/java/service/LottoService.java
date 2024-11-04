package service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import object.Lotto;

public class LottoService {

    public LottoService() {
    }

    public List<Lotto> makeRandomLottos(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }

        return lottos;
    }
}
