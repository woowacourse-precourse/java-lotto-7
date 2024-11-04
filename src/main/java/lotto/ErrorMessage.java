package lotto;

public enum ErrorMessage {
    INVALID_NUMBER_FORMAT("[ERROR] 숫자로 입력해 주세요."),
    INVALID_PRICE_UNIT("[ERROR] 1000원 단위 숫자로 입력해 주세요."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개입니다."),
    INVALID_RANGE("[ERROR] 1부터 45까지의 숫자를 입력해주세요."),
    INVALID_WINNING_NUMBER("[ERROR] 유효한 당첨번호를 입력해 주세요."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자를 입력할 수 없습니다."),
    INVALID_BONUS("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");

    private final String message;   // enum의 각 상수에 정의된 문자열을 뜻하는 인스턴스 변수

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}