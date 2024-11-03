package lotto.common.constant;

import lotto.view.OutputView;

public enum ErrorMessage {

    LOTTO_SHOULD_BE_SIX("로또 번호는 6개여야 합니다."),
    PRICE_SHOULD_BE_INTEGER("로또를 사려는 가격은 정수여야 합니다."),
    PRICE_SHOULD_BE_DIVIDED_BY_1000("로또를 사려는 가격은 1000원 단위여야 합니다."),
    PRICE_MUST_NOT_BE_NULL("로또를 사려는 가격은 null일 수 없습니다.");

    private final String errorMessage;
    private final String errorLogo = "[ERROR] ";

    ErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorLogo + errorMessage;
    }

    public void printErrorMessage() {
        OutputView.printMessage(errorLogo + errorMessage);
    }
}
