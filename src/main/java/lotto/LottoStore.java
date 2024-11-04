package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoStore(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int count = purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
