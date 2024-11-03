package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private static final String PAYMENT_NOT_NULL = "로또 구입 금액이 null이어서는 안 됩니다.";
    private final List<Lotto> lottos;

    public PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
        purchase();
    }

    public static PurchasedLotto from(Payment payment) {
        validate(payment);
        return new PurchasedLotto(new ArrayList<>(payment.getValue() / LOTTO_PRICE));
    }

    public List<Lotto> get() {
        return this.lottos;
    }

    public String getFormatted() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            result.append(lotto.getPrintFormatNumber()).append("\n");
        }
        return result.toString();
    }

    public int getCount() {
        return this.lottos.size();
    }

    private void purchase() {
        for(int i = 0; i< this.lottos.size(); i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }
    }

    private static void validate(Payment payment) {
        if(payment == null) {
            throw new IllegalArgumentException(ERROR_HEADER + PAYMENT_NOT_NULL);
        }
    }
}
