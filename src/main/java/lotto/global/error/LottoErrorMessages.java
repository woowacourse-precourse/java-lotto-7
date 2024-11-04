package lotto.global.error;

public enum LottoErrorMessages {

    INVALID_MATCH_COUNT("[ERROR] ", "유효하지 않은 매치 카운트입니다."),
    INVALID_LOTTO_NUMBER("[ERROR] ", "로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("[ERROR] ", "로또 번호에는 중복된 숫자가 없어야 합니다.");

    private final String message;
    private final String code;

    LottoErrorMessages(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return code + message;
    }
}
