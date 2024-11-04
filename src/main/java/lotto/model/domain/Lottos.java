package lotto.model.domain;

import lotto.dto.LottosDto;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalStateException("[ERROR] 로또 목록은 비어있을 수 없습니다.");
        }
    }
}