package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMaker {

    public static List<Lotto> makeLottos(Long count) {

        return Stream.generate(LottoMaker::makeLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static Lotto makeLotto() {
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(uniqueNumbers);
        return new Lotto(uniqueNumbers);
    }
}
