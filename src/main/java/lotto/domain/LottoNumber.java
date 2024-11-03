package lotto.domain;

public class LottoNumber {

    private final Integer value;

    private LottoNumber(Integer value) {
        this.value = value;
    }

    public static LottoNumber valueOf(Integer value) {
        validate(value);
        return new LottoNumber(value);
    }

    public static LottoNumber valueOf(String value) {
        return valueOf(Integer.parseInt(value));
    }

    private static void validate(Integer value) {
        isBetweenLottoNumberRule(value);
    }

    private static void isBetweenLottoNumberRule(Integer value) {
        if (value < 1 || value > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 수여야 합니다.");
        }
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LottoNumber that = (LottoNumber) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
