package lotto.view;

public class MoneyInputView extends InputView {
    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";

    public String inputMoney() {
        System.out.println(REQUEST_INPUT_MONEY);
        String input = inputValue();

        return input;
    }
}
