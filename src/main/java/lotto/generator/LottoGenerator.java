package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class LottoGenerator {

    private final int lottoPrice;
    private final int lottoNumberMin;
    private final int lottoNumberMax;
    private final int lottoNumberCount;

    public LottoGenerator(int lottoPrice, int lottoNumberMin, int lottoNumberMax, int lottoNumberCount) {
        this.lottoPrice = lottoPrice;
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
        this.lottoNumberCount = lottoNumberCount;
    }

    public LottoBundle generateLottoBundle(int lottoPurchasePrice){
        return LottoBundle.of(generateLottos(lottoPurchasePrice));
    }

    private List<Lotto> generateLottos(int lottoPurchasePrice) {
        int lottoCount = lottoPurchasePrice / lottoPrice;

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(lottoNumberMin, lottoNumberMax, lottoNumberCount);
    }

}
