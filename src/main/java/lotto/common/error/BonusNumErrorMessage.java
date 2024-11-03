package lotto.common.error;


public enum BonusNumErrorMessage implements ErrorMessage {

    INVALID_BONUS_NUMBER("보너스 번호는 1에서 45 사이여야 합니다."),
    CONFLICT_BONUS_NUMBER("보너스 번호가 당첨 번호에 포함될 수 없습니다.");



    private final String info;
    private final String message;

    BonusNumErrorMessage(String message) {
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
