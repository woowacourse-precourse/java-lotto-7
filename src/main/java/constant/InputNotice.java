package constant;

public enum InputNotice {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요");

    private final String inputNotice;

    InputNotice(String inputNotice) {
        this.inputNotice = inputNotice;
    }

    public String show() {
        return inputNotice;
    }
}
