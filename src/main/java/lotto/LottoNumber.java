package lotto;

public class LottoNumber {

    private final Integer value;

    private LottoNumber(Integer value) {
        this.value = value;
    }

    public static LottoNumber valueOf(Integer value) {
        validate(value);
        return new LottoNumber(value);
    }

    private static void validate(Integer value) {
        isBetweenLottoNumberRule(value);
    }

    private static void isBetweenLottoNumberRule(Integer value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("당첨 번호는 1~45 사이의 수여야 합니다.");
        }
    }

    public Integer getValue() {
        return value;
    }
}
