package lotto;

public enum InputMessage {
    AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_INPUT_MESSAGE("보너스 번호를 입력해 주세요.");


    private final String message;

    InputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
