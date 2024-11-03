package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGame {
    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer LOTTO_RANGE_START = 1;
    private static final Integer LOTTO_RANGE_END = 45;
    private static final Integer LOTTO_LENGTH = 6;

    private final List<Lotto> generatedLottos;
    private final Integer lottoCount;

    public LottoGame(final Integer purchaseAmount) {
        this.lottoCount = calcLottoCount(purchaseAmount);
        this.generatedLottos = generateLottos();
    }

    public List<Lotto> getGeneratedLottos() {
        return generatedLottos;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    private Integer calcLottoCount(final Integer purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> generateLottos() {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_LENGTH)))
                .toList();
    }
}
