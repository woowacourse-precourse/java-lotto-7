package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
            return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
            return parseNumbers(input);
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
            return Integer.parseInt(input);
    }

    private static List<Integer> parseNumbers(String input) {
        return List.of(input.split(",")).stream().map(Integer::parseInt).toList();
    }
}
