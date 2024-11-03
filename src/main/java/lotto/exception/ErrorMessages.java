package lotto.exception;

public enum ErrorMessages {
    // 로또 번호 관련 오류
    LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호에 중복된 숫자가 포함되어야 합니다."),
    LOTTO_NUMBERS_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
    LOTTO_TICKETS_NULL("로또 티켓은 null이거나 비어 있을 수 있습니다."),
    WINNING_NUMBERS_NULL("당첨 번호는 null일 수 없습니다."),
    BONUS_NUMBER_DUPLICATE("bonusNumber는 mainNumber와 중복될 수 없습니다."),
    BONUS_NUMBER_RANGE("bonusNumber는 1과 45 사이의 숫자여야 합니다."),

    // 금액 관련 오류
    MONEY_NULL("Money 객체는 null일 수 없습니다."),
    PRICE_NULL("price 가 null일 수 없습니다."),
    AMOUNT_INVALID("금액은 0보다 커야 하며, 1,000원 단위여야 합니다."),
    OTHER_NULL("더할 금액이 null입니다."),
    ORIGIN_MONEY_NULL("originMoney 는 null일 수 없습니다."),

    // 당첨 통계 관련 오류
    WINNING_STATISTICS_NULL("WinningStatistics는 null일 수 없습니다."),
    PROFIT_RATE_NULL("ProfitRate는 null일 수 없습니다."),

    // 일반 검증 오류
    MATCH_COUNT_NEGATIVE("matchCount는 음수가 될 수 없습니다."),
    MAIN_NUMBERS_NULL("mainNumbers가 null일 수 없습니다."),
    BONUS_NUMBER_NULL("bonusNumber가 null일 수 없습니다."),

    // 기타 오류
    INVALID_FORMAT("유효하지 않은 형태 입니다."),
    MAX_RETRY_EXCEEDED("재시도 횟수를 초과했습니다."),
    DIVIDE_BY_ZERO("0으로 나눌 수 없습니다."),

    // 당첨 규칙 관련 오류
    WINNING_RULE_NULL("WinningRule이 null일 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
