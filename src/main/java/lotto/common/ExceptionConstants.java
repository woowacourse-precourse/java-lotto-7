package lotto.common;

public enum ExceptionConstants {
    OVER_NUMBER_RANGE("[ERROR] ","당첨번호 범위 초과"),
    OVER_NUMBER_SIZE("[ERROR] ","당첨번호 갯수 오류"),
    DUPLICATE_BONUS_NUMBER("[ERROR] ","보너스 번호 당첨번호 중복 발생"),
    DUPLICATE_NUMBER("[ERROR] ","당첨번호 중복 발생"),
    NOT_BUY_UNIT("[ERROR] ","구매 단위 오류"),
    NOT_INTEGER("[ERROR] ","정수가 아님"),
    IS_NULL("[ERROR] ","빈 문자열");

    private final String errorCode;
    private final String errorMsg;

    ExceptionConstants(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorCode + errorMsg;
    }

}
