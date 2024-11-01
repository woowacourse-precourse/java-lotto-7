package lotto.constant;

public enum ErrorMessage {
    NOT_INPUT_BLANK("[ERROR] 빈칸을 입력하셨습니다!"),
    NOT_NUMBER_PURCHASE_AMOUNT("[ERROR] 구입금액에 숫자를 입력해 주세요!"),
    TOO_BIG_PURCHASE_AMOUNT("[ERROR] 구입금액이 너무 큽니다!"),
    LESS_THAN_THOUSAND_PURCHASE_AMOUNT("[ERROR] 구입금액에 1000 이상의 숫자를 입력해 주세요!"),
    NOT_PURCHASE_AMOUNT_FORMAT("[ERROR] 구입금액은 1000단위로 입력해 주세요!"),
    NOT_NUMBER_WINNING_NUMBER("[ERROR] 당첨 번호에 숫자를 입력해 주세요!"),
    NOT_SIX_WINNING_NUMBER("[ERROR] 당첨 번호에 6개의 숫자를 입력해 주세요!"),
    NOT_NUMBER_RANGE_WINNING_NUMBER("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야합니다!"),
    NOT_NUMBER_BONUS_NUMBER("[ERROR] 당첨 번호에 숫자를 입력해 주세요!"),
    NOT_NUMBER_RANGE_BONUS_NUMBER("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야합니다!"),
    DUPLICATE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복되지 않는 숫자여야합니다!"),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 중복되지 않는 숫자여야합니다!");

    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

}
