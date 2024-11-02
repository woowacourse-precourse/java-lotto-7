package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
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
        List<Integer> uniqueNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_COUNT);
        return new Lotto(uniqueNumbers);
    }
}
