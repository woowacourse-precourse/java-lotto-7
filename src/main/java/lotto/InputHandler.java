package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    public static int getBuyingPrice() {
        String buyingPrice = Console.readLine();
        return Integer.parseInt(buyingPrice);
    }
    public static List<Integer> getWinningNumber() {
        String winningNumbers = Console.readLine();
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
