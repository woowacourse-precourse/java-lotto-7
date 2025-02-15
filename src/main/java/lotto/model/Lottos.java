package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    public List<LottoDTO> toDtoList() {
        return lottos.stream()
                .map(Lotto::toDto)
                .collect(Collectors.toList());
    }
}
