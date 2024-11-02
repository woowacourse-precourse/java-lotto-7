package lotto.view;

import lotto.view.InputProvider.InputProvider;

public class ConsoleInput {
    public static final String PURCHASE_AMOUNT_HINT = "구입금액을 입력해 주세요.";
    public static final String WINNER_NUMBERS_HINT = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_HINT = "보너스 번호를 입력해 주세요.";

    final private InputProvider inputProvider;

    // constructor

    public ConsoleInput(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    // public methods

    public String getPurchasedAmount() {
        String input = readUserInput(PURCHASE_AMOUNT_HINT);
        printNewLine();
        return input;
    }

    public String getWinningNumbers() {
        String input = readUserInput(WINNER_NUMBERS_HINT);
        printNewLine();
        return input;
    }

    public String getBonusNumber() {
        String input = readUserInput(BONUS_NUMBER_HINT);
        printNewLine();
        return input;
    }

    public void close() {
        inputProvider.close();
    }

    // private methods

    private void printNewLine() {
        System.out.println();
    }

    private String readUserInput(String hint) {
        System.out.println(hint);
        return inputProvider.readLine();
    }

}
