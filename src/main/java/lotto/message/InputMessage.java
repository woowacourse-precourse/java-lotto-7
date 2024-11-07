package lotto.message;

public enum InputMessage {
    INPUT_BUY_AMOUNT("구입 금액을 입력하세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(message);
    }

}
