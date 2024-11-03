package lotto.view;

public class NumberInputView extends InputView {

    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = inputValue();

        return input;
    }

    public static String getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = inputValue();

        return input;
    }
}
