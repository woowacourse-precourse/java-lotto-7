package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;
import lotto.exception.LottoExceptionMessage;

public class LottoSalesService {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public List<Lotto> createLottos(int quantity) throws IllegalArgumentException {
        validateQuantity(quantity);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto(randomNumberGenerator.generate(1, 45, 6));
            lottos.add(lotto);
        }
        return lottos;
    }

    public int getAvailableLottoQuantity(int payment) throws IllegalArgumentException {
        validatePayment(payment);
        if (payment % 1000 == 0) {
            return payment / 1000;
        }
        throw new IllegalArgumentException(LottoExceptionMessage.PAYMENT_DIVISIBLE_BY_THE_LOTTO_PRICE);
    }

    private void validateQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.POSITIVE_OR_ZERO_QUANTITIES);
        } else if (quantity == Integer.MAX_VALUE) {
            throw new IllegalArgumentException(LottoExceptionMessage.QUANTITIES_LESS_THAN_INTEGER_MAX_VALUE);
        }
    }

    private void validatePayment(int payment) throws IllegalArgumentException {
        if (payment <= 0) {
            throw new IllegalArgumentException(LottoExceptionMessage.PAYMENT_MORE_THAN_ZERO);
        }
    }
}
