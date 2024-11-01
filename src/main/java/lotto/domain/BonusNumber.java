package lotto.domain;

public class BonusNumber extends LottoNumber {

    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MSG = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public BonusNumber(int number, Lotto winningNumber) {
        super(number);
        validate(winningNumber);
    }

    public BonusNumber(LottoNumber number, Lotto winningNumber) {
        super(number);
        validate(winningNumber);
    }

    public static BonusNumber parse(String input, Lotto winningNumber) {
        return new BonusNumber(LottoNumber.parseLottoNumber(input), winningNumber);
    }

    private void validate(Lotto winningNumber) {
        if (winningNumber.hasBonusNumber(this)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MSG);
        }
    }
}
