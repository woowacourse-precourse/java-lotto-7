package lotto.global.error;

public enum LottoErrorMessages {

    INVALID_MATCH_COUNT("유효하지 않은 매치 카운트입니다.");

    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
