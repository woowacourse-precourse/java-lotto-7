package lotto.enumerate;

public enum ErrorPrint {
    PURCHASE_MONEY_MUST_UNIT("[ERROR] 로또의 가격단위와 다릅니다."),
    INPUT_HAS_WRONG_PATTERN("[ERROR] 숫자가 아닌 다른 입력값이 들어왔습니다."),
    LOTTO_DOES_NOT_HAVE_CORRECT_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DOES_NOT_ALLOW_DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복된 숫자가 존재하지 않아야합니다.");
    private final String msg;

    ErrorPrint(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
