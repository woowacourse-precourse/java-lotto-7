package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.message.ExceptionMessage;

public record Lottos(List<Lotto> lottoItems) {

    public Lottos {
        validateNull(lottoItems);
    }

    private void validateNull(List<Lotto> lottoItems) {
        if (lottoItems == null) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL);
        }
    }

    public static Lottos purchaseLottos(Money money) {
        List<Lotto> lottoItems = new ArrayList<>();
        for (int i = 0; i < money.getPurchasableLottoCount(money); i++) {
            Lotto newLotto = Lotto.createRandomLotto();
            lottoItems.add(newLotto);
        }
        return new Lottos(lottoItems);
    }

    public int size() {
        return lottoItems.size();
    }
}