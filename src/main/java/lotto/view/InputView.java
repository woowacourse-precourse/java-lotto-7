package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import lotto.constant.SystemMessage;

public class InputView {
    public int inputPrice() {
        System.out.println(SystemMessage.Input_Price.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public int[] inputWinningNumbers() {
        System.out.println(SystemMessage.Input_WinningNumbers.getMessage());
        String winningNumbers = Console.readLine();

        return Arrays.stream(winningNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int inputBonusNumber() {
        System.out.println(SystemMessage.Input_BonusNumber.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
