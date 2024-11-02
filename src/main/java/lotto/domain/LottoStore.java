package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.LottoException;
import lotto.util.LottoNumberGenerator;

public class LottoStore {
    private final int LOTTO_PRICE = 1_000;

    public Lottos sell(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = calculateLottoCount(purchaseAmount);
        try{
            return new Lottos(getLottos(lottoCount));
        }catch(Exception e){
            return sell(purchaseAmount);
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoException.LOWER_PURCHASE_AMOUNT);
        }
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoException.INVALID_PURCHASE_AMOUNT);
        }
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> getLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto() {
        return new Lotto(LottoNumberGenerator.generate());
    }
}
