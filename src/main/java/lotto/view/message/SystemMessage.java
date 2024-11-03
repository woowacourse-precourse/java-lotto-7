package lotto.view.message;

public enum SystemMessage {

    INPUT_PURCHASE_MONEY_AMOUNT("구입금액을 입력해주세요");

    private String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
