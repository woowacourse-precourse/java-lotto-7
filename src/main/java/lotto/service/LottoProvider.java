package lotto.service;

import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoProvider {
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    public List<Lotto> buyLottoBundle(Cash cash){
        List<Lotto> lottoBundle = new ArrayList<>();
        int lottoCount = cash.getPurchasableLottoCount();
        for (int i = 0; i < lottoCount; i++){
            lottoBundle.add(new Lotto(lottoNumberGenerator.generateLottoNumbers()));
        }
        return lottoBundle;
    }
}
