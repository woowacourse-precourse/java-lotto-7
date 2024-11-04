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
        System.out.println("당첨 번호를 입력해주세요.");
        String winningNumbers = Console.readLine();
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
