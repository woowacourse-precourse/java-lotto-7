package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoManager;
import lotto.utils.RandomNumbersSelector;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoManager lottoManager;

    public LottoService(LottoGenerator lottoGenerator, LottoManager lottoManager) {
        this.lottoGenerator = lottoGenerator;
        this.lottoManager = lottoManager;
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);
            lottoManager.createLottosByRandomNumbers(lottoNumbers);
        }
    }


    public int calculateBuyLottoCount(int buyLottoMoney) {
        int lottoCount = buyLottoMoney / 1000;
        return lottoCount;
    }
}
