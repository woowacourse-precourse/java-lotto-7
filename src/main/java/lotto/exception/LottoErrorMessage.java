package lotto.exception;

public enum LottoErrorMessage {

    IS_NOT_POSSIBLE_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_NOT_CORRECT_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    HAVE_DUPLICATED_NUMBER("[ERROR] 로또 번호 중 중복되는 숫자가 존재하면 안 됩니다."),
    SEPARATE_ONLY_COMMA("[ERROR] 당첨 번호는 공백 없이 숫자를 쉼표(,)를 기준으로 구분합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
