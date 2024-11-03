package lotto;

import global.utils.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator extends RandomNumberGenerator {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> generateLottoList(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = calculateLottoCount(purchaseAmount);
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    public Integer getTotalSales(int purchaseAmount) {
        return (purchaseAmount / LOTTO_PRICE) * LOTTO_PRICE;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
        }
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = super.generateUniqueRandomNumbers(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
        return new Lotto(numbers);
    }
}
