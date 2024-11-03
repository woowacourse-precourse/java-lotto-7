package lotto.domain;

import static lotto.constant.NumberType.LOTTO_COUNT;
import static lotto.constant.NumberType.LOTTO_MAX_NUMBER;
import static lotto.constant.NumberType.LOTTO_MIN_NUMBER;
import static lotto.constant.NumberType.LOTTO_PRICE_UNIT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;
    private final int price;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.price = lottos.size() * LOTTO_PRICE_UNIT.getNumber();
    }

    public static Lottos from(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getNumber(),
                    LOTTO_MAX_NUMBER.getNumber(), LOTTO_COUNT.getNumber());
            lottos.add(new Lotto(integers));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    public int getPrice() {
        return price;
    }
}
