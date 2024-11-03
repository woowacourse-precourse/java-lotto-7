package lotto.view;

public class NumberInputView extends InputView {

    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER);
        String input = inputValue();

        return input;
    }

    public static int getBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        String input = inputValue();

        validateIsNumeric(input);
        return Integer.parseInt(input);
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("보너스 번호는 숫자 형식이어야 합니다.");
        }
    }
}
