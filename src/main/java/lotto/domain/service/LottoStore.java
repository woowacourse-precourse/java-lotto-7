package lotto.domain.service;

import lotto.domain.entity.Lotto;
import lotto.exception.PayException;
import lotto.exception.PayExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public List<Lotto> issuanceLottos(final int pay) {
        validatePayment(pay);

        final int lottoCount = pay % LOTTO_PRICE;

        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    private void validatePayment(final int pay) {
        if (isPaymentValid(pay)) {
            throw new PayException(PayExceptionMessage.PAY_BOUNDED_EXCEPTION);
        }
    }

    private boolean isPaymentValid(final int pay) {
        return pay < LOTTO_PRICE;
    }
}
