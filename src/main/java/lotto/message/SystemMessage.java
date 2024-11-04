package lotto.message;

public enum SystemMessage implements MessageProvider {

    MESSAGE_INPUT_PURCHASE_AMOUNT("구매금액을 입력해 주세요."),
    MESSAGE_INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    MESSAGE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MESSAGE_OUTPUT_PURCHASE_LOTTO_QUANTITY("개를 구매했습니다."),
    MESSAGE_OUTPUT_RESULT("당첨 통계"),
    MESSAGE_FIRST_RESULT("6개 일치"),
    MESSAGE_SECOND_RESULT("5개 일치, 보너스 볼 일치"),
    MESSAGE_THIRD_RESULT("5개 일치"),
    MESSAGE_FOURTH_RESULT("4개 일치"),
    MESSAGE_FIFTH_RESULT("3개 일치"),
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
