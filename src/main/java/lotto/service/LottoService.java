package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoStorage;

import java.util.List;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final LottoStorage lottoStorage;

    public LottoService(LottoGenerator lottoGenerator, LottoStorage lottoStorage) {
        this.lottoGenerator = lottoGenerator;
        this.lottoStorage = lottoStorage;
    }

    public void createLottoStorage(String buyLottoMoney) {
        int buyLottoCount = lottoGenerator.calculateBuyLottoCount(Integer.parseInt(buyLottoMoney));
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottoStorage.addLotto(lotto);
        }
    }
}
