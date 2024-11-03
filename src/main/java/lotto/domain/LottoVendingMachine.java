package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.vo.PurchaseAmount;

public class LottoVendingMachine {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoVendingMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public PurchasedLottos purchase(PurchaseAmount purchaseAmount) {
        int lottoCount = purchaseAmount.calculateLottoCount();

        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.from(lottoNumberGenerator.generateLottoNumbers()))
                .toList();
        return PurchasedLottos.of(lottos);
    }
}
