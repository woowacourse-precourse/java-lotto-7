package lotto.common;

public enum Instruction {
    INPUT_MONEY("구입금액을 입력해주세요."),
    BUY_LOTTO("개를 구매했습니다."),
    INPUT_WIN_NUMBERS("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요."),
    SHOW_RESULT("""
            당첨 통계
            ---""");

    private final String message;

    Instruction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
