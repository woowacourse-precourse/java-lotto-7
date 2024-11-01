package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.enums.LottoConfig;

public class LottoDispenser {
    private final LottoConfig lottoConfig;

    private LottoDispenser(LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public static LottoDispenser fromConfig(LottoConfig lottoConfig) {
        return new LottoDispenser(lottoConfig);
    }

    public LottoBundle issueLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        List<Lotto> lottos = issueLottos(lottoPurchasePrice.getLottoCount());
        return LottoBundle.ofLottosAndPurchasePriceAndConfig(lottos, lottoPurchasePrice, lottoConfig);
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
