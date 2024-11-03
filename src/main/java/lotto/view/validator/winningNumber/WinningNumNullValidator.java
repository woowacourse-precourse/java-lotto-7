package lotto.view.validator.winningNumber;

import lotto.view.validator.NullValidator;

public class WinningNumNullValidator extends NullValidator {

    private WinningNumNullValidator() {
        super("당첨 번호는 빈 문자열일 수 없습니다.");
    }

    public static WinningNumNullValidator initiate() {
        return new WinningNumNullValidator();
    }
}
