package lotto.model.lotto;

import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;
import lotto.model.lotto.validator.LottoStoreValidator;

public class LottoStore {
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStore(Long purchaseAmount) {
        this(new RandomLottoGenerator(), purchaseAmount);
    }

    public LottoStore(LottoGenerator lottoGenerator, long purchaseAmount) {
        LottoStoreValidator.validate(purchaseAmount);
        generateLottos(lottoGenerator, purchaseAmount);
    }

    private void generateLottos(LottoGenerator lottoGenerator, long purchaseAmount) {
        int lottoCount = (int) (purchaseAmount / LOTTO_PURCHASE_AMOUNT);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoGenerator.generateLotto()));
        }
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
