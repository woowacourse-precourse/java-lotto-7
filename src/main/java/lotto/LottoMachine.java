package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
	private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> issue(int amount) {
        validatePurchaseAmount(amount);
        int count = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        
        return lottos;
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

}
