package lotto.domain.util;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class CreateLottoList {

    public static List<Lotto> create(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount / 1000; i++) {
            List<Integer> lottoNumbers = CreateLotto.lotto();
            lottos.add(new Lotto(lottoNumbers));
        }
        return lottos;
    }
}
