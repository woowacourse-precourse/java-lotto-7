package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int lottoAmount) {
        return Stream.generate(LottoGenerator::generateSortedLottoNumbers)
                .limit(lottoAmount)
                .map(Lotto::new)
                .toList();
    }

    private static List<Integer> generateSortedLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .toList();
    }
}
