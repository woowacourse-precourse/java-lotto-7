package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int inputPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumber() {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbers = Console.readLine().split(",");
        for(String inputNumber : inputNumbers) {
            numbers.add(Integer.parseInt(inputNumber));
        }
        return numbers;
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
