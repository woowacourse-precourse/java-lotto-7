package lotto.service.issuing;

import java.util.ArrayList;
import java.util.List;
import lotto.factory.LottosFactory;
import lotto.model.Lottos;
import lotto.strategy.number.LottoNumberGeneratorStrategy;

public class LottoIssuingServiceImpl implements LottoIssuingService {
    private final LottoNumberGeneratorStrategy lottoNumberGenerator;

    public LottoIssuingServiceImpl(LottoNumberGeneratorStrategy lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    @Override
    public Lottos issueLottos(int purchaseAmount) {
        List<List<Integer>> allNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            allNumbers.add(lottoNumberGenerator.generate());
        }

        return LottosFactory.createLottos(allNumbers);
    }
}
