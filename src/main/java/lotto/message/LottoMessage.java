package lotto.message;

public enum LottoMessage {
    INPUT_BUY_AMOUNT("구입 금액을 입력하세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해주세요.");

    private String message;
    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return String.format(message);
    }

}
