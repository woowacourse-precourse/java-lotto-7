package lotto;

public enum ExceptionMessages {
    NOT_INTEGER_EXCEPTION_MESSAGE("[ERROR] 정수값이 아닌 값이 들어왔습니다."),
    EMPTY_EXCEPTION_MESSAGE("[ERROR] 빈문자열이 들어왔습니다."),
    NULL_EXCEPTION_MESSAGE("[ERROR] null값이 들어왔습니다."),
    LOTTO_BOUNDARY_OVER_EXCEPTION_MESSAGE("[ERROR] 로또 번호가 범위를 벗어나는 번호가 있습니다."),
    LOTTO_COUNT_OVER_EXCEPTION_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_EXCEPTION_MESSAGE("[ERROR] 로또 번호에 중복된 번호가 있습니다."),
    SINGLETON_NOT_CREATED_EXCEPTION_MESSAGE("[ERROR] 싱글톤 객체가 생성되기 전에 불렀습니다."),
    WINNING_RANK_EXCEPTION_MESSAGE("[ERROR] 당첨 등수로 들어올 수 없는 값이 들어왔습니다."),
    PURCHASE_BOUNDARY_OVER_EXCEPTION_MESSAGE("[ERROR] 구입 금액은 1_000이상 100_000 이하의 값만 가능합니다."),
    PURCHASE_MULTIPLE_THOUSAND_EXCEPTION_MESSAGE("[ERROR] 구입 금액은 1000원 단위로만 가능합니다.");

    final private String message;

    public String getMessage() {
        return message;
    }

    ExceptionMessages(String message) {
        this.message = message;
    }
}
