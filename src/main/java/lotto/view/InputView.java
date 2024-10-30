package lotto.view;

import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static int readPurchaseAmount(){
        System.out.println("구입 금액을 입력해 주세요");
        String input=readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String input=readLine();
        return parseNumbers(input);
    }

    public static int readBonusNumber() {
        System.out.print("보너스 번호를 입력해 주세요.");
        String input=readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : splitInput) {
            validateNumber(number);
            numbers.add(Integer.parseInt(number.trim()));
        }

        return numbers;
    }
    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
