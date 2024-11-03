package lotto.domain;

public class BonusNumber {

    private final LottoNumber value;

    private BonusNumber(LottoNumber value) {
        this.value = value;
    }

    public static BonusNumber of(LottoNumber value, LottoNumbers numbers) {
        validate(value, numbers);
        return new BonusNumber(value);
    }

    public static BonusNumber of(String value, LottoNumbers numbers) {
        return of(LottoNumber.valueOf(value), numbers);
    }

    private static void validate(LottoNumber value, LottoNumbers numbers) {
        isNotDuplicated(value, numbers);
    }

    private static void isNotDuplicated(LottoNumber value, LottoNumbers numbers) {
        if(numbers.contains(value)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1~45 사이의 한가지 수여야 합니다.");
        }
    }

    public LottoNumber getValue() {
        return value;
    }
}
