package lotto.model;

import lotto.Lotto;
import lotto.model.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {

        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLottos(int amount) {
        int quantity = calculateLottoQuantity(amount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generateLottoNumber());
            lottos.add(lotto);
        }

        return lottos;
    }

    private int calculateLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
