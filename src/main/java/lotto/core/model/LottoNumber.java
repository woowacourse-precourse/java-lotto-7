package lotto.core.model;

import lotto.core.dto.LottoNumberDto;

public record LottoNumber(Integer value) {

    private static Integer MIN_VALUE = 1;

    private static Integer MAX_VALUE = 45;

    public LottoNumber {
        if (!LottoNumber.isNumber(value)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자만 가능합니다.");
        }
    }

    public static LottoNumber dtoOf(LottoNumberDto dto) {
        return new LottoNumber(dto.value());
    }

    public static boolean isNumber(Integer value) {
        return value != null && value >= MIN_VALUE && value <= MAX_VALUE;
    }
}
