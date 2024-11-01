package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.enums.LottoConfig;

public class LottoDispenser {
    private final LottoConfig lottoConfig;
    private static final int LOTTO_PRICE = 1_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoDispenser(LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public LottoBundle issueLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        return LottoBundle.from(issueLottos(lottoPurchasePrice.getLottoCount()), lottoConfig);
    }

    private List<Lotto> issueLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                lottoConfig.getLottoNumberMin(), lottoConfig.getLottoNumberMax(), lottoConfig.getLottoNumberCount());
    }


}
