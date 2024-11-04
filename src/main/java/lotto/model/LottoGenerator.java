package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final static int LOTTO_PRICE = 1000;
    private final static int MIN_RANGE_NUMBER = 1;
    private final static int MAX_RANGE_NUMBER = 45;
    private final static int LOTTO_NUMBERS_AMOUNT = 6;

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public List<Lotto> generate(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int quantity = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lotties = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = generateNumbers();
            Collections.sort(numbers);
            lotties.add(new Lotto(numbers));
        }
        return lotties;
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER,
                LOTTO_NUMBERS_AMOUNT);
        numbers = numbers.stream().sorted().collect(Collectors.toList());
        return numbers;
    }
}
