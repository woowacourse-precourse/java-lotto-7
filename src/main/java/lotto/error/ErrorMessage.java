package lotto.error;

public enum ErrorMessage {
    NOTNUMBERBUYAMOUNT("구매금액이 정수가 아닙니다."),
    NOTPER1000BUYAMOUNT("구매금액이 1000원 단위가 아닙니다."),
    NOTDELIMITERWINNUMBERS("입력된 당첨번호의 구분자가 ,가 아닙니다."),
    NOTNUMBERWINNUMBERS("당첨번호가 숫자가 아닙니다"),
    NOTNUMBERBONUSNUMBER("보너스 번호가 정수가 아닙니다."),
    OUTOFRANGEBONUSNUMBER("보너스숫자가 1~45 범위안에 존재하는 숫자가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
