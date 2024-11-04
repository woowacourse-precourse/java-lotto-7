package lotto.model.domain;

import lotto.dto.LottosDto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoInputErrorMessage.LOTTO_LIST_EMPTY_ERROR;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(final LottosDto lottosDto) {
        this(lottosDto.lottos().stream()
                .map(Lotto::new)
                .toList());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    private void validate(final List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalStateException(LOTTO_LIST_EMPTY_ERROR.getMessage());
        }
    }
}