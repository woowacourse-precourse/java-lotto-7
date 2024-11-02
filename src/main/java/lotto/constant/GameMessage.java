package lotto.constant;

public enum GameMessage {
    GAME_PRINT_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public void printGameMessage() {
        System.out.println(this.message);
    }
}
