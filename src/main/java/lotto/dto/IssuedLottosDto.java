package lotto.dto;

import java.util.List;

public record IssuedLottosDto(
        int numberOfLottos,
        List<LottoDto> lottos
) {
    public IssuedLottosDto(List<LottoDto> lottos) {
        this(lottos.size(), lottos);
    }
}
