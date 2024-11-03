package service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private static final int LOTTO_PRICE = 1000;

    @Override
    public List<Lotto> generateLottos(int amount) {
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
        }
        return lottos;
    }
}
