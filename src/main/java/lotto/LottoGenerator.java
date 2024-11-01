package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static List<Lotto> getLotto(int amount) {
        return IntStream.range(0, amount)
               .mapToObj(i -> new Lotto(getRandomLottoNumber()))
               .collect(Collectors.toList());
    }

    public static List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
    }
}
