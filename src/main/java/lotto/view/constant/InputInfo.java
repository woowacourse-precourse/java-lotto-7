package lotto.view.constant;

public enum InputInfo {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    LUCKY_NUMBER("보너스 번호를 입력해 주세요.");

    private final String info;

    InputInfo(String info) {
        this.info = info;
    }

    public String guide() {
        return info;
    }
}
