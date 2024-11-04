package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    public static List<Lotto> generateLottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int count = calculateLottoCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private static int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}