package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.LottoNumberGenerator;

public class LottoService {

    public Lottos createLottos(Amount amount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = getLottoCount(amount);

        while (lottoCount-- > 0) {
            lottos.add(createLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();

        return new Lotto(lottoNumbers);
    }

    private int getLottoCount(Amount amount) {
        return amount.getAmount() / 1000;
    }

}
