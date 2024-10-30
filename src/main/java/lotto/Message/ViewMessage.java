package lotto.Message;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_GET_AMOUNT("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");


    public final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
