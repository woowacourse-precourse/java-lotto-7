package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public enum Input {
        PURCHASE_PRICE("구입금액을 입력해 주세요."),
        WIN_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Input(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static String inputPurchasePrice() {
        System.out.println(Input.PURCHASE_PRICE.getMessage());
        return Console.readLine();
    }

    public static String inputWinNumbers() {
        System.out.println();
        System.out.println(Input.WIN_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(Input.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
