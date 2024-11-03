package lotto.constants;

public enum LottoWinNumberException {
    NUMBER_ONLY_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    SAME_NUMBER_NOT_ALLOWED("[ERROR] 로또 번호는 중복될 수 없습니다"),
    NUMBER_RANGE("[ERROR] 로또 번호 1~45의 정수로 입력하세요.");

    private final String message;

    LottoWinNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
