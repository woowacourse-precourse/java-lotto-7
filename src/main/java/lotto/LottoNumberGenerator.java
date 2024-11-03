package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public static Lottos generate(Integer totalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            lottos.add(generateLottoNumber());
        }
        return Lottos.of(lottos);
    }

    private static Lotto generateLottoNumber() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);
        return Lotto.of(lotto);
    }

}
