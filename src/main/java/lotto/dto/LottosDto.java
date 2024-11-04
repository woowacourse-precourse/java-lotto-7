package lotto.dto;

import lotto.model.Lottos;

import java.util.List;

public record LottosDto(int lottoCount, List<LottoDto> lottos) {

    public static LottosDto from(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLottos()
                .stream()
                .map(LottoDto::from)
                .toList();
        return new LottosDto(lottos.getLottoCount(), lottoDtos);
    }
}
