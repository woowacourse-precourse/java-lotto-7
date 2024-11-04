package lotto.global.dto.response;

import java.util.List;
import lotto.back.lotto.domain.Lotto;

public record LottoResponseDTO(List<Integer> numbers) {

    public static LottoResponseDTO from(Lotto lotto) {
        return new LottoResponseDTO(lotto.getNumbers());
    }
}
