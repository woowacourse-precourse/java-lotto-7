package lotto.common.error;


public enum LottoErrorMessage implements ErrorMessage {

    INSUFFICIENT_WINNER_NUMBERS("로또 번호는 6개여야 합니다."),
    CONFLICT_WINNER_NUMBERS("로또 번호에 중복이 존재할 수 없습니다."),
    INVALID_WINNER_NUMBERS("당첨 번호가 1에서 45 사이여야 합니다.");


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
    @Override
    public String getInfoMessage() {
        return getInfo() + getMessage();
    }
}
