package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class InputView {

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분하여 6개 입력)");
        String[] inputs = splitInput(Console.readLine());
        return parseNumbers(inputs);
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

    private static List<Integer> parseNumbers(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(parseNumber(input));
        }
        return numbers;
    }

    private static int parseNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return parseNumber(Console.readLine());
    }

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseNumber(Console.readLine());
    }
}
