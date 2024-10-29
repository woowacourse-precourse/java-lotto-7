package lotto.service;

import lotto.Lotto;
import lotto.domain.PurchasedLotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_NUM_PICK_CNT = 6;

    private final LottoNumGenerator lottoNumGenerator;

    public LottoService(LottoNumGenerator lottoNumGenerator) {
        this.lottoNumGenerator = lottoNumGenerator;
    }

    public PurchasedLotto issueLottoNumAsPurchaseQuantity(final int quantity) {
        List<Lotto> lottos = issueLotto(quantity);
        return new PurchasedLotto(lottos);
    }

    private List<Lotto> issueLotto(final int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<Integer> numbers = generateLottoNumbers();
        return new Lotto(numbers);
    }

    private List<Integer> generateLottoNumbers() {
        return lottoNumGenerator.generateNumbers(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_NUM_PICK_CNT);
    }
}
