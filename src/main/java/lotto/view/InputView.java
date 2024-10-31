package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public enum Message {
        INPUT_BUDGET("구입금액을 입력해주세요."), INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."), INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public String getBudget() {
        System.out.println(Message.INPUT_BUDGET.getMessage());
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println(Message.INPUT_LOTTO_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
