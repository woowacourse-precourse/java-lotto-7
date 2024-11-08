package lotto.model.domain;

import lotto.exception.LottoErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    private void validate(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            if (lotto == null) {
                throw new IllegalArgumentException(LottoErrorMessage.EMPTY_LOTTO_VALUE.getMessage());
            }
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }
}
