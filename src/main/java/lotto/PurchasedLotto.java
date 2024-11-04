package lotto;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLotto {
    private static final String LOTTO_DELIMITER = "\n";

    private final List<Lotto> lottos;

    // 클래스 내부(from()), 테스트 환경에서만 사용하도록 설계된 생성자입니다. 일반 환경에서는 객체 생성을 지양해주세요.
    PurchasedLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLotto from(Payment payment) {
        int count = payment.get() / LOTTO_PRICE;
        return new PurchasedLotto(initialize(count));
    }

    private static List<Lotto> initialize(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i< count; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE, LOTTO_COUNT);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(this.lottos);
    }

    public String getFormatted() {
        StringBuilder result = new StringBuilder();
        for (Lotto lotto : this.lottos) {
            result.append(lotto.getFormatted());
            result.append(LOTTO_DELIMITER);
        }
        return result.toString();
    }

    public int getCount() {
        return this.lottos.size();
    }
}
