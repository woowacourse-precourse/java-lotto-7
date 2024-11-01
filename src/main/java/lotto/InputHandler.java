package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    public static int getBuyingAmount() {
        String buyingAmount = Console.readLine();
        return Integer.parseInt(buyingAmount);
    }
    public static List<Integer> getWinningNumber() {
        String winningNumbers = Console.readLine();
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
