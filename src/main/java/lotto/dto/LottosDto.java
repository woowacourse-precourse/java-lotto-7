package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import java.util.List;
import java.util.stream.Collectors;

public class LottosDto {
    private final List<LottoDto> lottos;

    public LottosDto(Lottos lottos) {
        this.lottos = createDto(lottos);
    }

    private List<LottoDto> createDto(Lottos lottos) {
        return lottos.getLottos()
                .stream()
                .map(l -> mapping(l))
                .collect(Collectors.toList());
    }

    private LottoDto mapping(Lotto l) {
        return new LottoDto(l.getNumbers()
                .stream()
                .map(n -> n.getNumber())
                .collect(Collectors.toList()));
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }
}
