package lotto.view.validator.winningNumber;

import lotto.view.validator.RangeValidator;

public class WinningNumRangeValidator extends RangeValidator {


    private WinningNumRangeValidator() {
        super("당첨 번호 중 1-45 범위 이외의 유효하지 않은 숫자가 존재합니다.");
    }

    public static WinningNumRangeValidator initiate() {
        return new WinningNumRangeValidator();
    }
}
