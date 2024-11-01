package lotto.model.lotto;

import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;

public class LottoStore {
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStore(Long amount) {
        this(new RandomLottoGenerator(), amount);
    }

    public LottoStore(LottoGenerator lottoGenerator, long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = (int) (purchaseAmount / LOTTO_PURCHASE_AMOUNT);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoGenerator));
        }
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }

        if (purchaseAmount % LOTTO_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 " + LOTTO_PURCHASE_AMOUNT + "원 단위여야 합니다.");
        }
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
