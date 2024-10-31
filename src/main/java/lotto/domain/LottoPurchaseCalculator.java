package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.error.LottoError;
import lotto.io.InputHandler;
import lotto.util.RandomNumberGenerator;

public class LottoPurchaseCalculator {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoPurchaseCalculator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int getLottoCount(String price) {
        try {
            int parsedPrice = Integer.parseInt(price);
            if (parsedPrice < 1000) {
                throw new IllegalArgumentException(LottoError.INVALID_PRICE.getMessage());
            }
            if (parsedPrice % 1000 != 0) {
                throw new IllegalArgumentException(LottoError.INVALID_PRICE_AMOUNT.getMessage());
            }
            return Integer.parseInt(price) / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public List<List<Integer>> generateLottoNumbers(int count) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = randomNumberGenerator.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }
}
