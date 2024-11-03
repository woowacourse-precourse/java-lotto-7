package lotto.common.factory;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    public static Lottos sizeFrom(int size) {
        Lottos lottos = new Lottos();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.addLotto(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
