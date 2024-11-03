package lotto.utils;

public enum ErrorMessage {

    INVALID_MONEY_INPUT("1000원 단위 이상의 돈을 입력해주세요."),
    INVALID_LOTTO_NUM("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_WINNER_NUMBER("콤마로 구분한 로또 번호만 입력해주세요."),
    INVALID_BONUS_NUM("사용 불가능한 보너스 번호입니다."),
    BIG_MONEY("구입 금액이 크거나 처리할 수 없는 당첨 금액입니다!"),

    NOT_HAVE_BONUS_NUM("보너스 번호가 들어가지 않았습니다."),
    NOT_SAVE_MONEY("돈이 저장되지 않았습니다."),
    NOT_SAVE_WINNER_STATUS("당첨 정보들이 저장되지 않았습니다."),
    NOT_SAVE_LOTTO_LIST("로또 번호들이 저장되지 않았습니다."),
    NOT_SAVE_WINNER_LOTTO("당첨 번호를 입력하지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
