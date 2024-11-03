package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    public static Lottos generate(Integer totalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < totalLottoCount; i++) {
            lottos.add(generateLottoNumber());
        }
        return Lottos.of(lottos);
    }

    private static Lotto generateLottoNumber() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lotto);
        Set<LottoNumber> result = lotto.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        return Lotto.from(result);
    }

}
