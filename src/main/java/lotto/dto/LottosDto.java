package lotto.dto;

import lotto.model.domain.Lottos;

import java.util.List;

public record LottosDto(List<LottoDto> lottos) {

    public LottosDto(Lottos lottos) {
        this(lottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList());
    }
}