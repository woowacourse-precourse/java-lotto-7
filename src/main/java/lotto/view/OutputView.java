package lotto.view;

public enum OutputView {

    ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    EXIT_APPLICATION("회 이상 실패로 앱이 종료됩니다."),
    PURCHASED_LOTTO_COUNT("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),


    ;

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public static void printMessage(OutputView view) {
        System.out.println(view.message);
    }

    public static void printMessage(String output) {
        System.out.println(output);
    }

    public String getMessage() {
        return message;
    }

}
