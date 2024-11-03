package lotto.view;

public enum InputGuide {
    ACCOUNT("구입금액을 입력해 주세요."),
    NUMBER_SELECT("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    InputGuide(String message) {
        this.message = message;
    }

    public void guidePrint() {
        System.out.println(message);
    }
}
