package lotto.domain.number;

public class BonusNumber {
    private static final String ERROR_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    private final LottoNumber number;

    private BonusNumber(LottoNumber number) {
        this.number = number;
    }

    public LottoNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number.toString();
    }
}