package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.SystemMessage;

public class InputView {
    public int inputPrice() {
        System.out.println(SystemMessage.Input_Price.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(SystemMessage.Input_WinningNumbers.getMessage());
        String winningNumbers = Console.readLine();

        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(SystemMessage.Input_BonusNumber.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
