package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstants.*;

public abstract class LottoListGenerator {

    public static List<Lotto> generateLottos(int count) {
//        List<Lotto> lottos = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT);
//            Collections.sort(numbers);
//            lottos.add(new Lotto(numbers));
//        }
//        return lottos;
        return IntStream.range(0, count)
                .mapToObj(i -> {

                })
    }
}
