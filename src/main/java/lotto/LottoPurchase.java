package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private final LottoGenerator generator;

    public LottoPurchase(LottoGenerator generator) {
        this.generator = generator;
    }

    // 금액만큼 로또 구매
    public List<Lotto> purchase(int payment) {
        // 1000단위 검증
        validate(payment);

        // 로또 생성
        List<Lotto> lottos = new ArrayList<>();
        int amount = payment / 1000;
        for (int i = 0; i < amount; i++) {
            lottos.add(generator.generate());
        }
        return lottos;
    }

    // 로또 금액이 1000원단위로떨어지는지 검증
    private void validate(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000원단위로 떨어져야합니다.");
        }
    }
}
