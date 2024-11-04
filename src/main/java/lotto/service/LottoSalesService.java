package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;

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
        throw new IllegalArgumentException("로또는 1000원 단위로 구입할 수 있습니다.");
    }

    private void validateQuantity(int quantity) throws IllegalArgumentException {
        if (quantity < 0) {
            throw new IllegalArgumentException("수량은 0보다 작을 수 없습니다.");
        } else if (quantity == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("수량은 Integer.MAX_VALUE 보다 클 수 없습니다.");
        }
    }

    private void validatePayment(int payment) throws IllegalArgumentException {
        if (payment <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }
}
