package lotto.service;


import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.generator.LottoGenerator;

public class LottoService {
    public LottoService(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    private final LottoGenerator lottoGenerator;

    public int getLottoCountByAmount(int purchaseAmount) {
        LottoCount lottoCount = new LottoCount(purchaseAmount);
        return lottoCount.getCount();
    }

    public List<Lotto> getLottosByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.createRandomNumberLotto(lottoGenerator))
                .toList();
    }

}
