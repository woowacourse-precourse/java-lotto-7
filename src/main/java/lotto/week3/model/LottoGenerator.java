package lotto.week3.model;

import java.util.ArrayList;
import java.util.List;
import lotto.week3.domain.Lotto;


public class LottoGenerator {

    public static List<Lotto> generatorLottos(int cost) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cost; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
