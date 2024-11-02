package lotto.view;

public enum OutputView {
    PURCHASE_COUNT("%d개를 구매했습니다."),
    WINNING_RESULT("당첨 통계\\n---\\n"),
    DETAIL_RESULT("%d개 일치 (%,d)원 - %d개"),
    RATE_OF_RETURN("총 수익률은 %.2f%%입니다.");

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void printMessage(Object... args) {
        System.out.println(String.format(message, args));
    }

    public void errorMessage(RuntimeException e) {
        System.out.println(e.getMessage());
    }
}
