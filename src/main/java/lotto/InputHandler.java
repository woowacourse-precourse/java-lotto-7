package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    static final int LOTTO_PRICE = 1000;

    /**
     *
     * @return 해당 가격으로 구매할 수 있는 로또 개수
     */
    public static int getBuyingAmount() {
        String buyingAmount = Console.readLine();
        return Integer.parseInt(buyingAmount)/LOTTO_PRICE;
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
