package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.error.LottoError;
import lotto.util.RandomNumberGenerator;

public class LottoPurchaseCalculator {
    private final RandomNumberGenerator randomNumberGenerator;

    public LottoPurchaseCalculator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int getLottoCount(String price) {
        int parsedPrice = parsePrice(price);
        validatePrice(parsedPrice);
        return parsedPrice / 1000;
    }

    private int parsePrice(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(LottoError.INVALID_PRICE.getMessage());
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(LottoError.INVALID_PRICE_AMOUNT.getMessage());
        }
    }

    public List<Lotto> generateLottoNumbers(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = generateLotto();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = randomNumberGenerator.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}