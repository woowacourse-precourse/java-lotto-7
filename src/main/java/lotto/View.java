package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    public static final String COST_INFORMATION = "구입금액을 입력해 주세요.";
    public static final String NUMBERS_INFORMATION = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INFORMATION = "보너스 번호를 입력해 주세요.";

    private String getInput(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();

        return input;
    }

    public String getPurchaseCost() {
        return getInput(COST_INFORMATION);
    }

    public String getWinningNumbers() {
        return getInput(NUMBERS_INFORMATION);
    }

    public String getBonusNumber() {
        return getInput(BONUS_NUMBER_INFORMATION);
    }

    public void println(List<String> messages) {
        messages.forEach(System.out::println);
        System.out.println();
    }
    public void println(String message) {
        System.out.println(message + "\n");
    }

}
