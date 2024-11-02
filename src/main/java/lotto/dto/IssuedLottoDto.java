package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record IssuedLottoDto(List<Integer> lottoNumber) {
    public static IssuedLottoDto from(Lotto lotto) {
        return null;
    }
}
