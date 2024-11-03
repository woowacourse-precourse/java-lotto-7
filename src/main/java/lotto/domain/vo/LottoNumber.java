package lotto.domain.vo;

public class LottoNumber {
    private final Integer number;

    private LottoNumber(Integer number) {
        this.number = number;
    }

    public static LottoNumber of(Integer number) {
        return new LottoNumber(number);
    }

    public Integer getValue() {
        return number;
    }
}
