package lotto.service;

import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.domain.LottoResultFormatter;
import lotto.utils.RandomNumbersSelector;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoManager lottoManager;
    private final LottoResultFormatter lottoResultFormatter;

    public LottoService(LottoGenerator lottoGenerator, LottoManager lottoManager, LottoResultFormatter lottoResultFormatter) {
        this.lottoGenerator = lottoGenerator;
        this.lottoManager = lottoManager;
        this.lottoResultFormatter = lottoResultFormatter;
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);
            lottoManager.createLottosByRandomNumbers(lottoNumbers);
        }
    }

    public List<String> formatLottoNumbers() {
        return lottoResultFormatter.formatLottoNumbers(lottoManager.getLottos());
    }


    public int calculateBuyLottoCount(int buyLottoMoney) {
        int lottoCount = buyLottoMoney / 1000;
        return lottoCount;
    }
}
