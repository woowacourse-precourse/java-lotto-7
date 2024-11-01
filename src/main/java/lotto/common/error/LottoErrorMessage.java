package lotto.common.error;


public enum LottoErrorMessage implements ErrorMessage {


    // 입력 검증 예외 처리
    INVALID_PURCHASE_AMOUNT_UNIT("구입 금액은 1,000원 단위여야 합니다."),
    INVALID_PURCHASE_AMOUNT_VALUE("구입 금액은 0원 이상이어야 합니다."),
    INSUFFICIENT_WINNER_NUMBERS("당첨 번호가 6개여야 합니다."),
    CONFLICT_WINNER_NUMBERS("당첨 번호에 중복이 존재할 수 없습니다."),
    INVALID_WINNER_NUMBERS("당첨 번호가 0에서 45 사이여야 합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 0에서 45 사이여야 합니다."),
    CONFLICT_BONUS_NUMBER("보너스 번호가 당첨 번호에 포함될 수 없습니다.");


    private static final String ERROR_PREFIX = "[ERROR]";
    private final String info;
    private final String message;

    LottoErrorMessage(String message) {
        this.info = ERROR_PREFIX;
        this.message = message;
    }

    @Override
    public String getInfo() {
        return info;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
