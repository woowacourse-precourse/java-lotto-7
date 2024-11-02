package lotto.view;

public class InputView {
    static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputLottoPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return System.console().readLine();
    }

}
