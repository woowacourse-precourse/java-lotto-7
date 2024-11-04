package lotto.dto;

import java.util.List;
import lotto.model.Lottos;

public record LottosDto(List<LottoDto> lottos) {
    public static LottosDto from(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
        return new LottosDto(lottoDtos);
    }
}
