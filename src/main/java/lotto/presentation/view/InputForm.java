package lotto.presentation.view;

import camp.nextstep.edu.missionutils.Console;

public class InputForm {

    public static String read(Header header) {
        System.out.println(header.toString());
        return Console.readLine();
    }

    public enum Header {
        PAY_AMOUNT("구입금액을 입력해 주세요."),
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String text;

        Header(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
