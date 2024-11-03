package lotto.core.dto;

import lotto.core.model.LottoNumber;

public record LottoNumberDto(Integer value) {

    public static LottoNumberDto modelOf(LottoNumber number) {
        return new LottoNumberDto(number.value());
    }
}
