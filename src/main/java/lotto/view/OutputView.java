package lotto.view;

public enum OutputView {

    ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    EXIT_APPLICATION("회 이상 실패로 앱이 종료됩니다.")

    ;

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public static void printMessage(OutputView view) {
        System.out.println(view.message);
    }

    public String getMessage() {
        return message;
    }

}
