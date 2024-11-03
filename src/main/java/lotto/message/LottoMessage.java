package lotto.message;

public enum LottoMessage {

    // View message
    DISPLAY_LOTTO_COUNT("%s개를 구매했습니다."),
    DISPLAY_LOTTO_RESULT("당첨 통계"),
    DISPLAY_LOTTO_RESULT_BOUNDARY("---"),

    // Error message
    OUT_OF_RANGE_LOTTO_AMOUNT("[ERROR] 구매 가능한 로또 수량을 초과했습니다."),
    OUT_OF_RANGE_LOTTO_NUMBER_AMOUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    IS_NOT_ASCENDING_NUMBER("[ERROR] 로또 번호가 오름차순 정렬되지 않았습니다."),
    IS_DUPLICATE_NUMBER("[ERROR] 로또 번호가 중복되었습니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
