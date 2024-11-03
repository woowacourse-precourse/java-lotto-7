package lotto.domain;

import static lotto.utils.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.utils.Constants.MAX_BOUND;
import static lotto.utils.Constants.MIN_BOUND;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle {

    private final List<Lotto> lotteries;

    private LottoBundle(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static LottoBundle of(int count) {
        List<Lotto> lotteries = Stream.generate(
                        () -> new Lotto(Randoms.pickUniqueNumbersInRange(MIN_BOUND, MAX_BOUND, LOTTO_NUMBERS_SIZE)))
                .limit(count).collect(Collectors.toList());
        return new LottoBundle(lotteries);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
