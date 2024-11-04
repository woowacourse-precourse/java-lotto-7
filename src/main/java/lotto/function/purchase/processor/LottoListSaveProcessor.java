package lotto.function.purchase.processor;

import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.util.generator.LottoGenerator;

public class LottoListSaveProcessor {

    private final LottoGenerator lottoGenerator;
    private final LottoRepository lottoRepository;

    public LottoListSaveProcessor(
            LottoGenerator lottoGenerator,
            LottoRepository lottoRepository
    ) {
        this.lottoGenerator = lottoGenerator;
        this.lottoRepository = lottoRepository;
    }

    public List<Lotto> saveLottoList(int purchasableCount) {
        List<Lotto> generatedLottoList = lottoGenerator.generateByCount(purchasableCount);
        lottoRepository.saveAll(generatedLottoList);
        return generatedLottoList;
    }

}
