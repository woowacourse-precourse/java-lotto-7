package lotto.domain.lotto.vo;

import lotto.infrastructure.exception.CustomException;

public record LottoNumber(int value) {
    public static final int MAX = 45;
    public static final int MIN = 1;

    public static LottoNumber of(final int number) {
        validate(number);
        return new LottoNumber(number);
    }

    public boolean sameAs(LottoNumber other) {
        return other.value == value;
    }

    private static void validate(final int number) {
        if (number > MAX || number < MIN) {
            throw new CustomException("로또 번호는 1 ~ 45 사이의 숫자만 입력될 수 있습니다.");
        }
    }
}
