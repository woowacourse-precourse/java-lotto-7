package lotto.week3.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.week3.domain.Lotto;


public class LottoGenerator {

    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> generatorLottos(int cost) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cost; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT);
            lottos.add(new Lotto(integers));
        }
        return lottos;
    }

}
