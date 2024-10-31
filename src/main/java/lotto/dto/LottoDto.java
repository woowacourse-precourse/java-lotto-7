package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottoDto(List<Integer> numbers) {

    public static LottoDto from(Lotto lotto) {
        return new LottoDto(lotto.getLottoNumbers());
    }
}
