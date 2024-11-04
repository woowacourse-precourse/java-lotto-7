package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.PurchasedLottos;
import lotto.util.NumberGenerate;

public class LottoMachine {

    private final NumberGenerate lottoGenerate;

    public LottoMachine(NumberGenerate numberGenerate) {
        this.lottoGenerate = numberGenerate;
    }

    public PurchasedLottos issueLotto(LottoMoney lottoMoney) {
        int lottoCount = lottoMoney.calculateLottoCount();

        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < lottoCount; cnt++) {
            List<Integer> numbers = lottoGenerate.randomGenerateInRange(Lotto.LOTTO_NUM_START, Lotto.LOTTO_NUM_END, Lotto.LOTTO_NUM_SIZE);
            lottos.add(new Lotto(numbers));
        }

        return new PurchasedLottos(lottos);
    }
}
