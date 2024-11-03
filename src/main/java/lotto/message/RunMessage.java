package lotto.message;

public enum RunMessage {
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n");


    private final String message;


    RunMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
