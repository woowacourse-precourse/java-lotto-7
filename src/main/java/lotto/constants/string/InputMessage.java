package lotto.constants.string;

import lotto.constants.Constants;

public enum InputMessage implements Constants<String> {

    PRICE("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getInstance() {
        return this.message;
    }
}
