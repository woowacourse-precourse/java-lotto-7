package lotto.domain;

import static lotto.constant.Error.MAX_AMOUNT_PURCHASE;
import static lotto.constant.Error.MIN_AMOUNT_PURCHASE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public static Lottos of(List<Lotto> lottos) {
        validate(lottos);

        Lottos newLottos = new Lottos();
        lottos.forEach(newLottos::add);
        return newLottos;
    }

    private static void validate(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(MIN_AMOUNT_PURCHASE);
        }

        if (lottos.size() > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_PURCHASE);
        }
    }
}
