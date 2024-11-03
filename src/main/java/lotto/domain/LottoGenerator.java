package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final RandomNumberGenerator randomNumberGenerator;
    private final Long lottoPrice;

    public LottoGenerator(RandomNumberGenerator randomNumberGenerator, Long lottoPrice) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.lottoPrice = lottoPrice;
    }

    public List<Lotto> purchaseLotto(Long purchasePrice) {
        validatePrice(purchasePrice);
        return generateLottos(purchasePrice / lottoPrice);
    }

    private void validatePrice(Long purchasePrice) {
        if (purchasePrice == 0L || purchasePrice % lottoPrice != 0L) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    private List<Lotto> generateLottos(Long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(randomNumberGenerator.generateNumbers(LOTTO_NUMBER_COUNT));
    }
}
