package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottosDTO(List<LottoDTO> lottos) {
    public static LottosDTO from(List<Lotto> lottos) {
        List<LottoDTO> lottoDTOs = lottos.stream()
                .map(lotto -> LottoDTO.of(lotto.getNumbers()))
                .toList();

        return new LottosDTO(lottoDTOs);
    }
}
