package lotto.common.constant;

import lotto.view.OutputView;

public enum ErrorMessage {

    LOTTO_SHOULD_BE_SIX("로또 번호는 6개여야 합니다."),
    PRICE_SHOULD_BE_INTEGER("로또를 사려는 가격은 정수여야 합니다."),
    PRICE_SHOULD_BE_DIVIDED_BY_1000("로또를 사려는 가격은 1000원 단위여야 합니다."),
    PRICE_MUST_NOT_BE_NULL("로또를 사려는 가격은 null일 수 없습니다."),
    PRICE_SHOULD_BE_SMALLER_THAN_LIMITS("로또를 사려는 가격은 2,000,000,000을 넘을 수 없습니다."),
    THERE_IS_DUPLICATE_NUMBER_IN_LOTTO("로또에 중복된 값이 있습니다."),
    NOT_MATCH_LOTTO_COUNT_WITH_PRICE("로또 가격과 개수가 일치하지 않습니다."),
    WINNING_LOTTO_NUMBER_FORMAT_ERROR("당첨 번호 형식이 알맞지 않습니다."),
    THERE_IS_DUPLICATE_NUMBER_IN_WINNING_LOTTO("당첨 번호에 중복된 숫자가 있습니다."),
    THERE_IS_INVALID_NUMBER_IN_WINNING_LOTTO("당첨번호는 1~45의 값만 가능합니다."),
    WINNING_LOTTO_MUST_NOT_START_END_WITH_COMMA("당첨번호 시작과 끝은 쉼표일 수 없습니다."),
    BONUS_NUMBER_FORMAT_ERROR("보너스 번호 형식이 알맞지 않습니다."),
    BONUS_NUMBER_MUST_NOT_BE_NULL("보너스 번호는 null일 수 없습니다."),
    THERE_IS_INVALID_NUMBER_IN_BONUS_NUMBER("보너스 번호는 1~45의 값만 가능합니다."),
    WINNING_NUMBER_CONTAINS_BONUS_NUMBER("보너스 번호는 당첨 번호에 포함될 수 없습니다."),
    WINNING_NUMBER_COUNT_ERROR("당첨 번호는 6글자여야 합니다.");

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
