package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    public static List<Lotto> createLottos(final int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        return IntStream.range(0, lottoAmount)
                .mapToObj(lotto -> LottoGenerator.generate())
                .toList();
    }

    private static Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }
}
