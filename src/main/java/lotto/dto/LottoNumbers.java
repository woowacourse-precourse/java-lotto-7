package lotto.dto;

import java.util.List;
import lotto.model.Lotto;

public record LottoNumbers (List<Integer> numbers){
    public static LottoNumbers of(Lotto lotto) {
        return new LottoNumbers(lotto.getNumbers());
    }
}
