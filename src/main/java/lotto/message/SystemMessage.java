package lotto.message;

public enum SystemMessage implements MessageProvider {

    MESSAGE_INPUT_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    MESSAGE_INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    MESSAGE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MESSAGE_OUTPUT_PURCHASE_LOTTO_COUNT("개를 구매하였습니다."),
    MESSAGE_OUTPUT_RESULT("당첨 통계"),
    ;

    private final String message;

    SystemMessage (String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
